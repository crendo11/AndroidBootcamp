package example.myapp

fun buildAquarium() {
    val myaquarium = Aquarium(25, 25, 40)
    myaquarium.printSize()
    // create a towertank
    val myTower = TowerTank(diameter = 25, height = 40)
    myTower.printSize()

    // create fishes for the tank
}
fun makeFish() {
    val shark = Shark()
    val pleco = Plecostomus()

    println("Shark: ${shark.color}")
    shark.eat()
    println("Pletocostomus: ${pleco.color}")
    pleco.eat()
}

fun main() {
    buildAquarium()
    makeFish()
}