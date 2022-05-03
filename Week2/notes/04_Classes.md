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

## Subclasses and Inheritance

In Kotlin, by default, classes cannot be subclassed. Similarly, properties and member variables cannot be overridden by subclasses (though they can be accessed).

You must mark a class as <code>open</code> to allow it to be subclassed. Similarly, you must mark properties and member variables as open, in order to override them in the subclass. The <code>open</code> keyword is required, to prevent accidentally leaking implementation details as part of the class's interface.

## Abstract Classes and Interfaces

Sometimes you want to define common behavior or properties to be shared among some related classes

- Neither an abstract class nor an interface can be instantiated on its own, which means you cannot create objects of those types directly.
- Abstract classes have constructors.
- Interfaces can't have any constructor logic or store any state.

### When to use abstract classes versus interfaces

Abstract classes have constructors, and interfaces cannot, but otherwise they are similar. 
When you use interfaces to compse a class. the class's functionality is extended by way of the class instances that it contains. Composition tends to make code easier to reuse and reason about than inheritance from abstract class.
Also, you can use multiple interfaces in a class, but you can only subclass from one abstract class.

Use an interface if you have a lot of methods and one or two default implementations, for example as in AquariumAction below.

```kotlin
interface AquariumAction {
    fun eat()
    fun jump()
    fun clean()
    fun catchFish()
    fun swim()  {
        println("swim")
    }
}
```

Use an abstract class any time you can't complete a class. For example, going back to the AquariumFish class, you can make all AquariumFish implement FishAction, and provide a default implementation for eat while leaving color abstract, because there isn't really a default color for fish.

```kotlin
interface FishAction  {
    fun eat()
}

abstract class AquariumFish: FishAction {
   abstract val color: String
   override fun eat() = println("yum")
}
```

