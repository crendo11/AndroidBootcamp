package example.myapp

fun buildAquarium() {
    val myaquarium = Aquarium(25, 25, 40)
    myaquarium.printSize()
    // create a towertank
    val myTower = TowerTank(diameter = 25, height = 40)
    myTower.printSize()
}

fun main() {
    buildAquarium()
}