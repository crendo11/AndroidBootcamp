// variables can be defined outside
val decorations = listOf("rock", "pagoda", "plastic plant", "alligator", "flowerpot")

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

    // force evaluation of the lazy list
    val newList = filtered.toList()
    println("new list: $newList")

    //
    val lazyMap = decorations.asSequence().map {
        println("access: $it")
        // executes some code here
        it
    }

    println("lazy: $lazyMap")
    println("-----")
    println("first: ${lazyMap.first()}")
    println("-----")
    println("all: ${lazyMap.toList()}")
}
