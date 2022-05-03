package example.myapp.Decoration

data class Decoration(val rocks: String) {
}
enum class Direction(val degrees: Int) {
    NORTH(0), SOUTH(180), EAST(90), WEST(270)
}

fun makeDecorations() {
    val decoration1 = Decoration("granite")
    println(decoration1)

    val decoration2 = Decoration("slate")
    println(decoration2)

    val decoration3 = Decoration("slate")
    println(decoration3)

    // method equals is provided by data classes
    println(decoration1.equals(decoration2))
    println(decoration3.equals(decoration2))

    // Here is a data class with 3 properties.
    data class Decoration2(val rocks: String, val wood: String, val diver: String) {
    }

    val d5 = Decoration2("crystal", "wood", "diver")
    println(d5)

    // Assign all properties to variables. deconstructing
    val (rock, wood, diver) = d5
    println(rock)
    println(wood)
    println(diver)

    // try class enum 
    println(Direction.EAST.name)
    println(Direction.EAST.ordinal)
    println(Direction.EAST.degrees)

}

fun main() {
    makeDecorations()
}