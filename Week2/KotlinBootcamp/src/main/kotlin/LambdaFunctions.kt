fun main(){
    // delcare varaible and lambda function
    var dirtyLevel = 20
    // define the variable and say that the type is a function
    val waterFilter: (Int) -> Int = { dirty -> dirty / 2 }
    println(waterFilter(dirtyLevel))
    // call the higher order funtion
    println(updateDirty(30, waterFilter))
    // use :: to pass a normal function
    println(updateDirty(15, ::increaseDirty))
    var dirtyLevel2 = 19;
    // the second parameter is a lambda function and can be passes outside of the perenthesis
    dirtyLevel2 = updateDirty(dirtyLevel) { dirtyLevel -> dirtyLevel * 2}
    println(dirtyLevel2)
}

// higher order function
fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
    return operation(dirty)
}

fun increaseDirty( start: Int ) = start + 1

