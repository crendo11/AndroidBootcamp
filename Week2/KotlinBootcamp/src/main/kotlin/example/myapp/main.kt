package example.myapp

fun buildAquarium() {
    val myAquarium = Aquarium()
    // call method
    myAquarium.printSize()
    // modifi properties
    myAquarium.height = 60
    myAquarium.printSize()
    // default height and length
    val aquarium2 = Aquarium(width = 25)
    aquarium2.printSize()
    // default width
    val aquarium3 = Aquarium(height = 35, length = 110)
    aquarium3.printSize()
    // everything custom
    val aquarium4 = Aquarium(width = 25, height = 35, length = 110)
    aquarium4.printSize()
    val aquarium5 = Aquarium(numberOfFish = 29)
    // call to create an Aquarium using your new secondary constructor. Print the size and volume.
    val aquarium6 = Aquarium(numberOfFish = 29)
    aquarium6.printSize()
    aquarium6.volume = 70
    aquarium6.printSize()
    // now it is not necessary to calculate volume
    // println("Volume: ${aquarium6.width * aquarium6.length * aquarium6.height / 1000} l")
}

fun main() {
    buildAquarium()
}