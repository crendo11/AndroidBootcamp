# Kotlin Basics

Basics of the Kotlin programming language: data types, operators, variables, control structures, and nullable versus non-nullable variables. 

## What I will learn

- How to use Kotlin data types, operators, and variables
- How to work with booleans and conditions
- The difference between nullable and non-nullable variables
- How arrays, lists, and loops work in Kotlin

## Learn about operators and types

As with other languages, Kotlin uses +, -, * and / for plus, minus, times and division. Kotlin also supports different number types, such as Int, Long, Double, and Float.

Numbers cannot be converted implicitly. Casting is necessary to such task.


```kotlin
val i: Int = 6
val b1 = i.toByte()
println(b1)
// 6
```

### Interesting Kotlin functionalty

To make long numeric constants more readable, Kotlin allows you to place underscores in the numbers, where it makes sense to you. Try entering different numeric constants.

```kotlin
val oneMillion = 1_000_000
val socialSecurityNumber = 999_99_9999L
val hexBytes = 0xFF_EC_DE_5E
val bytes = 0b11010010_01101001_10010100_10010010
```


## Compare Conditions and Booleans

### if / else statement:

```kotlin
val numberOfFish = 50
val numberOfPlants = 23
if (numberOfFish > numberOfPlants) {
    println("Good ratio!") 
} else {
    println("Unhealthy ratio")
}
// good ratio
```

Try a range in an if statement. In Kotlin, the condition you test can use ranges, too.
```kotlin
val fish = 50
if (fish in 1..100){
    println(fish)
}
// 50
```

else if 

```kotlin
if (numberOfFish == 0) {
    println("Empty tank")
} else if (numberOfFish < 40) {
    println("Got fish!")
} else {
    println("That's a lot of fish!")
}

// That's a lot of fish!
```
<code>when</code> in kotlin acts like a <code>switch</code> and also can be used in ranges, too.

<!--- long slution for gray background 
<span style="background: lightgray; color: black;border-radius: 3px;">&nbsp;when&nbsp;</span> 
-->

```kotlin
when (numberOfFish) {
    0  -> println("Empty tank")
    in 1..39 -> println("Got fish!")
    else -> println("That's a lot of fish!")
}
// That's a lot of fish!
```

## Leanr about nullability

By default, variables cannot be null.

Use the question mark operator, ?, after the type to indicate that a variable can be null. Declare an Int? and assign null to it.


```kotlin
var marbles: Int? = null
```

For testing if a variable is null, use the ? operatior. an example without the operator.


```kotlin
var fishFoodTreats = 6
if (fishFoodTreats != null) {
    fishFoodTreats = fishFoodTreats.dec()
}
```

Now with the operator

```kotlin
fishFoodTreats = fishFoodTreats?.dec() ?: 0
```

## A point about null pointers
If you really love <code>NullPointerExceptions</code>, Kotlin lets you keep them. The not-null assertion operator, <code>!!</code>  (double-bang), converts any value to a non-null type and throws an exception if the value is <code>null</code>.


## Lists

<b>Make lists</b>

To declare a list 
```kotlin
val school = listOf("mackerel", "trout", "halibut")
println(school)
// [mackerel, trout, halibut]
```

This list cannot be changed. To create that can be change, use the <code>mutableList</code>

```kotlin
val myList = mutableListOf("tuna", "salmon", "shark")
myList.remove("shark")
// res36: kotlin.Boolean = true
```

The remove() method returns true when it successfully removes the item passed.

**Create arrays**

Unlike lists, in Kotlin, which have mutable and immutable versions, there is no mutable version of an Array. Once you create an array, the size is fixed. You can't add or remove elements, except by copying to a new array.

The rules about using <code>val</code> and <code>var</code> are the same with arrays as with lists.

Declare an array of strings using <code>arrayOf</code>. Use the <code>java.util.Arrays.toString()</code> array utility to print it out.

```kotlin
val school = arrayOf("shark", "salmon", "minnow")
println(java.util.Arrays.toString(school))
// [shark, salmon, minnow]
```

An array declared with arrayOf doesn't have a type associated with the elements, so you can mix types, which is helpful. Declare an array with different types.

```kotlin
val mix = arrayOf("fish", 2)
```

You can also declare arrays with one type for all the elements. Declare an array of integers using <code>intarrayOf()</code>. There are corresponding builders, or instantiation functions, for arrays of other types.

Combine two arrays with the + operator.

Try out different combinations of nested arrays and lists. As in other languages, you can nest arrays and lists. That is, when you put an array within an array, you have an array of arrays—not a flattened array of the contents of the two. **The elements of an array can also be lists, and the elements of lists can be arrays.**

```kotlin
val numbers = intArrayOf(1, 2, 3)
val oceans = listOf("Atlantic", "Pacific")
val oddList = listOf(numbers, oceans, "salmon")
println(oddList)
// [[I@89178b4, [Atlantic, Pacific], salmon]
```

One nice feature of Kotlin is that you can initialize arrays with code instead of initializing them to 0. Try this example:

```kotlin
val array = Array (5) { it * 2 }
println(java.util.Arrays.toString(array))
// [0, 2, 4, 6, 8]
```

## Make loops
In Kotlin, you can loop through the elements and the indexes at the same time. Try this example:

```kotlin
for ((index, element) in school.withIndex()) {
    println("Item at $index is $element\n")
}
/*
Item at 0 is shark
Item at 1 is salmon
Item at 2 is minnow
*/
```

Try different step sizes and ranges. You can specify ranges of numbers or of characters, alphabetically. And as in other languages, you don't have to step forward by 1. You can step backward using downTo.

```kotlin
for (i in 1..5) print(i)
// 12345

for (i in 5 downTo 1) print(i)
// 54321

for (i in 3..6 step 2) print(i)
// 35

for (i in 'd'..'g') print (i)
// defg
```

## Summary
**Things that might be different than other languages**

- Kotlin types can't be implicitly converted. Use casting
- Variables declared with val can onle be assigned once-
- Kotlin variables are not nullable by default.
- With kotlin, you can loop through the index and elements of an array ate the same time in a for loop.

**Things that are similar to other languages**

- Arrays and lists can have a single type or mixed types.
- Arrays and lists can be nested.
- You can create loops with for, while, do/while, and repeat.
- The when statement is Kotlin's version of the switch statement, but when is more flexible.

## Homework

**Question 1**
Which of the following declares an unchangeable list of strings?

- [ ] val school = arrayOf("shark", "salmon", "minnow")

- [ ] var school = arrayOf("shark", "salmon", "minnow")

- [x] val school = listOf("shark", "salmon", "minnow")

- [ ] val school = mutableListOf("shark", "salmon", "minnow")

**Question 2**
What will be the output of the following code? for (i in 3..8 step 2) print(i)

- [ ] 345678

- [ ] 468

- [ ] 38

- [x] 357

**Question 3**
What is the purpose of the question mark in this code? var rocks: Int? = 3

- [ ] The type of the variable rocks isn't fixed.

- [x] The variable rocks can be set to null.

- [ ] The variable rocks cannot be set to null.

- [ ] The variable rocks shouldn't be initialized right away.


