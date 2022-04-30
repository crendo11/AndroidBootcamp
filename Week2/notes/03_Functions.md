# Functions in Kotlin

As with other languages, the Kotlin  <code>main()</code> function specifies the entry point for execution. Any command line arguments are passed as an array of strings.


## Pass arguments to main()

Because you are running your program from IntelliJ IDEA and not from the command line, you need to specify any arguments to the program a little differently.

1. Select **Run** >** Edit Configurations**. The **Run/Debug** Configurations window opens.
2. Type Kotlin! in the Program arguments field.
3. Click OK.

Use the value of an expression in a string template. Add some code to check the temperature to determine whether a fish is safe or too warm, then run your program.

```kotlin
val temperature = 10
val message = "The water temperature is ${ if (temperature > 50) "too warm" else "OK" }."
println(message)
// The water temperature is OK.
```

### Create some functions 

In this step, you put together some of what you've learned and create functions with different types. 

```kotlin
// Random and nextInt functions are defined in java.util
import java.util.*

fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)
    println("Today is $day and the fish eat $food")
}
// se when statement likewise a switch
fun fishFood (day : String) : String {
    return when (day) {
        "Monday" -> "flakes"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Sunday" -> "plankton"
        else -> "nothing"
    }
}

fun randomDay(): String{
    val week = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday",
        "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(week.size)]
}

fun main(args: Array<String>) {
    feedTheFish()
}
```

Adding a fuinction that implements <code>when</code>

```kotlin
// Random and nextInt functions are defined in java.util
import java.util.*

fun feedTheFish() {
    val day = randomDay()
    val food = "pellets"
    println("Today is $day and the fish eat $food")
}

fun randomDay(): String{
    val week = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday",
        "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(week.size)]
}

fun main(args: Array<String>) {
    feedTheFish()
}
```

## Create default value for a parameter

In Kotlin, you can pass arguments by parameter name. You can also specify default values for parameters: if an argument isn't supplied by the caller, the default value is used. Later, when you write methods (member functions), it means you can avoid writing lots of overload versions of the same method.

```kotlin
// parameters can be defined by default
fun swim(speed: String = "fast") {
    println("swimming $speed")
}

fun main(){
    swim()   // uses default speed
    swim("slow")   // positional argument
    swim(speed="turtle-like")   // named parameter
}

```

## Add required parameters

If no default is specified for a parameter, the corresponding argument must always be passed.

```kotlin
fun shouldChangeWater (day: String, temperature: Int = 22, dirty: Int = 20): Boolean {
    return when {
        temperature > 30 -> true
        dirty > 30 -> true
        day == "Sunday" ->  true
        else -> false
    }
}

fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)
    println("Today is $day and the fish eat $food")
    println("Change water: ${shouldChangeWater(day)}") // shouldchangeAter() must be called with the day parameter
}
```

## Make compact functions

Compact functions, or single-expression functions, are a common pattern in Kotlin. When a function returns the results of a single expression, you can specify the body of the function after an = symbol, omit the curly braces {}, and omit the return.

```kotlin
fun shouldChangeWater (day: String, temperature: Int = 22, dirty: Int = 20): Boolean {
    return when {
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) ->  true
        else -> false
    }
}

// Compact functions allow to write the body after the =
fun isTooHot(temperature: Int) = temperature > 30
fun isDirty(dirty: Int) = dirty > 30
fun isSunday(day: String) = day == "Sunday"
```

The default value for a parameter doesn't have to be a value. It can be another function.

## Get stated with filters

excercise of filtering words that start with 'p'

```kotlin
// variables can be defined outside
val decorations = listOf("rock", "pagoda", "plastic plant", "alligator", "flowerpot")

fun main(){
    // filter words starting with p
    println( decorations.filter {it[0] == 'p'})
}
```

There are two tipes of filters:

### Eager filters: 
the result list is created immediately

### Lazy filters:
The result list is created when accesed

By default, filter in kotlin is eager. To make the filter lazy, you can use a <code>Sequence</code>, which is a collection that can only look at one item at a time, starting at the beginning, and going to the end. 


// variables can be defined outside
val decorations = listOf("rock", "pagoda", "plastic plant", "alligator", "flowerpot")

```kotlin
fun main(){
    // filter words starting with p
    println( decorations.filter {it[0] == 'p'})
    /************** eager and lazy filters **************/
    // eager, creates a new list
    val eager = decorations.filter { it [0] == 'p' }
    println("eager: $eager")

    // Lay, will wait until asked to evaluate
    val filtered = decorations.asSequence().filter { it[0] == 'p' }
    println("filtered: $filtered")
}

/* 
[pagoda, plastic plant]
eager: [pagoda, plastic plant]
filtered: kotlin.sequences.FilteringSequence@7a07c5b4
*/

```

To visualize what's going on with the Sequence and lazy evaluation, use the map() function. The map() function performs a simple transformation on each element in the sequence.

```kotlin
    val lazyMap = decorations.asSequence().map {
        println("access: $it")
        // executes some code here
        it
    }

    println("lazy: $lazyMap") // prints the kotlin secuence
    println("-----")
    println("first: ${lazyMap.first()}") // prints the first acces: rock
    println("-----")
    println("all: ${lazyMap.toList()}") // Prints all the elements and then returns the 

```

## Lambdas and higher-order functions

### Lambdas 
A lambda is an expression that makes a function. But instead of declaring a named function, you declare a function that has no name. Part of what makes this useful is that the lambda expression can now be passed as data. In other languages, lambdas are called anonymous functions, function literals, or similar names.

### Higher order functions

You can create a higher-order function by passing a lambda to another function. 
<code> map </code> is a higher-order function, and the lambda you passed to it was the transformation to apply.

## Homework

### Question 1
The contains(element: String) function returns true if the string element is contained in the string it's called on. What will be the output of the following code?

val decorations = listOf ("rock", "pagoda", "plastic plant", "alligator", "flowerpot")

println(decorations.filter {it.contains('p')})

- [x] [pagoda, plastic, plant]

- [ ] [pagoda, plastic plant]

- [ ] [pagoda, plastic plant, flowerpot]

- [ ] [rock, alligator]

### Question 2
In the following function definition, which one of the parameters is required? fun shouldChangeWater (day: String, temperature: Int = 22, dirty: Int = 20, numDecorations: Int = 0): Boolean {...}

- [ ] numDecorations

- [ ] dirty

- [x] day

- [ ] temperature

### Question 3
You can pass a regular named function (not the result of calling it) to another function. How would you pass increaseDirty( start: Int ) = start + 1 to updateDirty(dirty: Int, operation: (Int) -> Int)?

- [ ] updateDirty(15, &increaseDirty())

- [ ] updateDirty(15, increaseDirty())

- [ ] updateDirty(15, ("increaseDirty()"))

- [x] updateDirty(15, ::increaseDirty)