package academy.learnprogramming.oochallenge

fun main() {
//    val bike = KotlinBicycle(1, 2, 3)
//    val mountainBike = KotlinMountainBike(1, 2, 3, 4)
//    val roadBike = KotlinRoadBike(1, 2, 3, 4)
//    bike.printDescription()
//    mountainBike.printDescription()
//    roadBike.printDescription()

//    val bike2 = KotlinBicycle(1, 2)
//    val mountainBike2 = KotlinMountainBike(1, 2, 3)
//    val roadBike2 = KotlinRoadBike(1, 2, 3)
//    bike2.printDescription()
//    mountainBike2.printDescription()
//    roadBike2.printDescription()

    val mountainBike3 = KotlinMountainBike(color = "Blue", 10, 10, 10)
    mountainBike3.printDescription()
    println(KotlinMountainBike.colors)

}

open class KotlinBicycle(var cadence: Int, var speed: Int, var gear: Int = 10) {

    fun applyBrake(decrement: Int) {
        speed -= decrement
    }

    fun speedUp(increment: Int) {
        speed += increment
    }

    open fun printDescription() {
        println("Bike is in gear $gear with a cadence of $cadence " +
                "travelling at a speed of $speed.")
    }

}

class KotlinMountainBike(var seatHeight: Int, cadence: Int, speed: Int, gear: Int = 10):
        KotlinBicycle(cadence, speed, gear) {

    constructor(color: String, seatHeight: Int, cadence: Int, speed: Int, gear: Int = 20) : this(seatHeight, cadence, speed, gear) {
        println("The color is $color")
    }

    override fun printDescription() {
        super.printDescription()
        println("The mountain bike has a seat height of $seatHeight inches.")
    }

    companion object {
        val colors = listOf("blue", "red", "white", "black", "green", "brown")
    }
}

class KotlinRoadBike(val tireWidth: Int, cadence: Int, speed: Int, gear: Int = 10):
        KotlinBicycle(cadence, speed, gear) {

    override fun printDescription() {
        super.printDescription()
        println("The road bike has a tire width of $tireWidth MM.")
    }

}


