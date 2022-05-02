# Object Oriented Programming

Packages can help to keep the code organized.

In Kotlin, you define the constructor directly in the class declaration itself, specifying the parameters inside parentheses as if the class was a method. As with functions in Kotlin, those parameters can include default values.

### Constructor overloading:
Constructors with different arguments. For example:
consider the class:

```kotlin
class Aquarium (var length: Int = 100, var width: Int = 20, var height: Int = 40){
    // decondary constructor
    constructor(numberOfFish: Int): this(){
        // 2,000 cm^3 per fish + extra room so water doesn't spill
        val tank = numberOfFish * 2000 * 1.1
        // calculate the height needed
        height = (tank / (length * width)).toInt()
        println("Scondary constructor activated")
    }
}

```

If I instance an Aquarium object without specifing the _numberOfFish_ variable, the log wont appear:



```kotlin
    val aquarium1 = Aquarium(width = 25, height = 35, length = 110)
    val aquarium2 = Aquarium(numberOfFish = 29);
    // Scondary constructor activated
```

## Visibility Modifiers

In Kotlin, classes, objects, interfaces, constructors, functions, properties, and their setters can have visibility modifiers:

- **public**: means visible outside the class. Everything is public by default, including variables and methods of the class.
- **internal**: means it will only be visible within that module. A module is a set of Kotlin files compiled together, for example, a library or application.
- **private**: means it will only be visible in that class (or source file if you are working with functions).
- **protected**: is the same as private, but it will also be visible to any subclasses.

If you want a property that your code can read or write, but outside code can only read, you can leave the property and its getter as public and declare the setter private, as shown below.

```kotlin
var volume: Int
    get() = width * height * length / 1000
    private set(value) {
        height = (value * 1000) / (width * length)
    }
```

