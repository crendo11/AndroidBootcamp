package example.myapp
import java.lang.Math.PI
// Add class constructor (implemented in the definition of the class)
open class Aquarium (open var length: Int = 100, open var width: Int = 20, open var height: Int = 40){
    // create open variable for volume
    open var volume: Int
        get() = width * height * length / 1000
        set(value) {
            height = (value * 1000) / (width * length)
        }

    // deifne variable for shape
    open val shape = "rectangle"

    //Add an open water property with a getter that returns 90% of the volume of the Aquarium
    open var water: Double = 0.0
        get() = volume * 0.9

    // funtion to return the the shape and the amount of voume occupied
    fun printSize() {
        println(shape)
        println("Width: $width cm " +
                "Length: $length cm " +
                "Height: $height cm ")
        // 1 l = 1000 cm^3
        println("Volume: $volume l Water: $water l (${water/volume*100.0}% full)")
    }
}

class TowerTank (override var height: Int, var diameter: Int): Aquarium(height = height, width = diameter, length = diameter) {
    override var volume: Int
    // ellipse area = pi * r1 * r2
        get() = (width/2 * length/2 * height / 1000 * PI).toInt()
        // set the value of the area given a volume
        set(value) {
            height = ((value * 1000 / PI) / (width/2 * length/2)).toInt()
        }
    // override itnernal variables
    override var water = volume * 0.8
    override val shape = "cylinder"

}