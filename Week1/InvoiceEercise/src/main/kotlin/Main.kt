import com.sun.org.apache.xpath.internal.operations.Bool

fun main(){
    // create a list of products
    var product1 = Product("Camisa", 150000F, true)
    var product2 = Product("Pantalon", 120000F, true)
    var product3 = Product("Zapatos", 250000F, true)
    // create list of discounts
    var discount1 = Discount(0.2F, "WELCOME")
    var discount2 = Discount(0.1F, "FIRSTBUY")

    // Create lists
    val products = mutableListOf<Product>(product1,product2,product3)
    val discounts = mutableListOf<Discount>(discount1, discount2)

    val invoice = Invoice(products, discounts)

    displayInvoice(invoice)
}

class Product(name: String, value: Float, includesIva: Boolean){
    val name: String = name;
    val value: Float = value;
    val includesIva: Boolean = includesIva;
}

class Invoice (var products: MutableList<Product> = mutableListOf<Product>(),
               var discounts: MutableList<Discount> = mutableListOf<Discount>()
    ){
    // Invoice internal variables
    var total: Float = 0F
    var totalDiscount: Float = 0F
    var totalWithDiscount: Float = 0F

    init{
        calcVariables()
    }
    // Methods for updating invoice variables
    fun calcVariables() {
        // call methods to update the variables
        calcTotal()
        calcTotalDiscounts()
        calculateTotalWithDiscount()
    }
    fun calcTotal() {
        // Calculate total value without any discount
        products.forEach { product ->
            total += product.value
        }
    }
    fun calcTotalDiscounts() {
        // calculate total amount of discounts
        var discountCount: Float = 0F
        discounts.forEach{discount ->
            discountCount += discount.value
        }
        totalDiscount = total * discountCount
    }
    fun calculateTotalWithDiscount() {
        totalWithDiscount = total - totalDiscount;
    }
    // Methods to add discounts and products to an invoice
    fun addProduct(product: Product){
        products.add(product)
        // update variables
        calcVariables()
    }

    fun addDiscount(discount: Discount) {
        discounts.add(discount)
        // update variables
        calcVariables()
    }


}
class Discount (value: Float, code: String){
    // value goes from 0 to 1
    var value: Float = value;
    var code: String = code;
}

fun displayInvoice(invoice: Invoice){
    // dsiplay total value
    println("El valor total es:    $${invoice.total}")
    println("Decuentos:            $${invoice.totalDiscount}")
    println("Total a pagar:        $${invoice.totalWithDiscount}")
}