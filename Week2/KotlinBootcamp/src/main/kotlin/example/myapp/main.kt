package example.myapp

fun buildAquarium() {
    val myAquarium = Aquarium()
    // call method
    myAquarium.printSize()
    // modifi properties
    myAquarium.height = 60
    myAquarium.printSize()
}

fun main() {
    buildAquarium()
}