# Kotlin Bootcamp Google Developers

## What I should already know:

- Basics of a modern, object-oriented, statically typed programing language.
- How to program with classes, methods and exception handling in at least one language.
- Using an IDE such as IntelliJ IDEA, Android studio, Eclipse, or Visual Studio.

## Benefits of Kotlin

Created by programmers for programmers. Focused on clarity conciseness, and safety.

### Robust Code
Kotlin ditinguishes between nullable and non-nullable data types, which helps catch more errors at compile time. Kotlin is strongly typed, and it does a lot to infer the types from your code. It has lambdas, coroutines, and properties, which allow you to write less code with fewer bugs.

### Mature Platform
- Created in 2011.
- Released as open source in 2012.
- Reached version 1.0 in 2016.
- Officialy supported language for building android apps in 2017.

### Concise, readable code

Consider de code: 

```java
public class Aquarium {

   private int mTemperature;

   public Aquarium() { }

   public int getTemperature() {
       return mTemperature;
   }

   public void setTemperature(int mTemperature) {
       this.mTemperature = mTemperature;
   }

   @Override
   public String toString() {
       return "Aquarium{" +
               "mTemperature=" + mTemperature +
               '}';
   }
}
```
It can be written loke this in kotlin:

```kotlin
data class Aquarium (var temperature: Int = 0)
```

### Interoperable with Java

Kotlin code compiles so that you can use Java and Kotlin code side-by-side, and continue to use your favorite Java libraries. You can add Kotlin code to an existing Java program, or if you want to migrate your program completely, IntelliJ IDEA and Android Studio both include tools to migrate existing Java code to Kotlin code.


## Homework

### Question 1
Which of the following is NOT a benefit of using the Kotlin language?

- [ ] Kotlin distinguishes between nullable and non-nullable data types.

- [ ] Kotlin is a supported language for building Android apps.

- [ ] Kotlin is designed so you can write less code with fewer bugs.

- [x] Your code compiles faster in Kotlin.

### Question 2
How do you start the Kotlin REPL?

- [ ] Type repl on the command line.

- [ ] Create a Kotlin project in IntelliJ IDEA, then select Run > Kotlin REPL.

- [ ] Open IntelliJ IDEA, then select File > Kotlin REPL.

- [x] Create a Kotlin project in IntelliJ IDEA, then select Tools > Kotlin > Kotlin REPL.

### Question 3
Which of the following is NOT true about Kotlin and Java code?

- [ ] Kotlin code and Java code can run side-by-side.

- [ ] You can add Kotlin code to an existing Java program.

- [ ] You can migrate existing Java code to Kotlin.

- [x] Kotlin code will run faster than Java code


## REPL
A read–eval–print loop (REPL), also termed an interactive toplevel or language shell, is a simple interactive computer programming environment that takes single user inputs, executes them, and returns the result to the user; 

