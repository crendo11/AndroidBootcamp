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

