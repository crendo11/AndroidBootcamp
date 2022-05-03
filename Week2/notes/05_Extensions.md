# Extensions

- Pairs and triples can be used to return more than one value from a function. For example: val twoLists = fish.partition { isFreshWater(it) }
- Kotlin has many useful functions for List, such as reversed(), contains(), and subList().
- A HashMap can be used to map keys to values. For example: val cures = hashMapOf("white spots" to "Ich", "red sores" to "hole disease")
- Declare compile-time constants using the const keyword. You can put them at the top level, organize them in a singleton object, or put them in a companion object.
- A companion object is a singleton object within a class definition, defined with the companion keyword.
- Extension functions and properties can add functionality to a class. For example: fun String.hasSpaces() = find { it == ' ' } != null
- A nullable receiver allows you to create extensions on a class which can be null. The ?. operator can be paired with apply to check for null before executing code. For example: this?.apply { println("removing $this") }

## Homework

### Question 1
Which one of the following returns a copy of a list?

- [ ] add()

- [ ] remove()

- [x] reversed()

- [ ] contains()

### Question 2
Which one of these extension functions on class AquariumPlant(val color: String, val size: Int, private val cost: Double, val leafy: Boolean) will give a compiler error?

- [ ] fun AquariumPlant.isRed() = color == "red"

- [ ] fun AquariumPlant.isBig() = size > 45

- [x] fun AquariumPlant.isExpensive() = cost > 10.00

- [ ] fun AquariumPlant.isNotLeafy() = leafy == false

### Question 3
Which one of the following is not a place where you can define constants with const val?

- [ ] at the top level of a file

- [x] in regular classes

- [ ] in singleton objects

- [ ] in companion objects