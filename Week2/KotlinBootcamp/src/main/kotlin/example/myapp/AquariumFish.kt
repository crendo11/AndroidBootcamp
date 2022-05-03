package example.myapp

// intead of inheritating from AquariumFish, create interfaces that pleco and shark are going to implement
/*abstract class AquariumFish {
    abstract val color: String
}*/

interface FishColor {
    val color: String
}
interface FishAction {
    fun eat()
}

// create a singleton class which is a class that implements FishColor
object GoldColor: FishColor {
    override val color = "gold"
}

// Interface delegation for FIshAction
class PrintingFishAction(val food: String): FishAction {
    override fun eat(){
        println(food)
    }
}

// create two classes that implement the interfaces
class Shark: FishAction, FishColor {
    override val color = "gray"
    // override eat action
    override fun eat() {
        println("Hunt and eat fish")
    }
}
// adding interface delegation for FishColor. The property color is delegated to GoldColor
class Plecostomus (fishColor: FishColor = GoldColor):
    FishAction by PrintingFishAction("eat algae"),
    FishColor by fishColor


