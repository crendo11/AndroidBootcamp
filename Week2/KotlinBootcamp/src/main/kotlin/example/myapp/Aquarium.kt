package example.myapp
// Add class constructor (implemented in the definition of the class)
class Aquarium (var length: Int = 100, var width: Int = 20, var height: Int = 40){
    // crerating getter for volume
    var volume: Int
        get() = width * height * length / 1000  // 1000 cm^3 = 1 l
        // setter
        set(value) {
            height = (value * 1000) / (width * length)
        }
    // secondary constructor
    constructor(numberOfFish: Int): this(){
        // 2,000 cm^3 per fish + extra room so water doesn't spill
        val tank = numberOfFish * 2000 * 1.1
        // calculate the height needed
        height = (tank / (length * width)).toInt()
        println("Scondary constructor activated")
    }
    // adding init blocks
    init {
        println("aquarium initializing")
    }
    // methods for the class
    fun printSize() {
        println("Width: $width cm " +
                "Length: $length cm " +
                "Height: $height cm ")
        // 1 l = 1000 cm^3
        println("Volume: $volume l")
    }
}