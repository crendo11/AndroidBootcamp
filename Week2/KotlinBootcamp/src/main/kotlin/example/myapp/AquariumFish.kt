package example.myapp

abstract class AquariumFish {
    abstract val color: String
}

// create two subclases of AquariumFish
class Shark: AquariumFish(), FishAction {
    override val color = "gray"
    // override eat action
    override fun eat() {
        println("Hunt and eat fish")
    }
}

class Plecostomus: AquariumFish(), FishAction {
    override val color = "gold"
    // override eat function
    override fun eat() {
        println("eat algae")
    }
}

interface FishAction {
    fun eat()
}

