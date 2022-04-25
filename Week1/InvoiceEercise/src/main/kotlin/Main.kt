fun main(){
    // create a list of products
    var product1 = Product("Camisa", 150000F);
    var product2 = Product("Pantalon", 120000F);
    var product3 = Product("Zapatos", 250000F);

    val products = arrayOf<Product>(product1,product2,product3);

    var totalValue: Float = 0F;
    // calculate total value
    products.forEach{
        totalValue += it.value;
    }

    // pint total price
    println("El costo total de los productos es: $${totalValue}");

    //calc discount
    println("Introduce un porcentaje de descuento: ")
    var discount = readLine()!!.toFloat();
    discount /= 100;
    println("El descuento ingresado fue del: ${discount * 100}%")
    // apply discount
    var payingPrice: Float = totalValue * (1 - discount);
    println("El costo total es: $${payingPrice}")
}

class Product(name: String, value: Float){
    val name: String = name;
    val value: Float = value;
}
