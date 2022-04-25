// If I declare de variable in the kotlin file refered as top level variables
val name: String = "Cristian";
// nulable strings. string can be null if you add a question mark
var lastname: String? = null;


fun main() {
    // defining variables in kotlin
    // mutable variables using var
    var mutableVar: String = "You can change my value";
    // inmutable variables with val
    val inmutableVar: String = "You cannot change my value";  // variable in local scope

    // log mutable variable
    println("Before changing the value:")
    println(mutableVar)

    mutableVar = "new value"

    println("After changing the value")
    println(mutableVar)

    // assign lastname
    lastname = "Rendon"
    println(name)
    println(lastname)

}