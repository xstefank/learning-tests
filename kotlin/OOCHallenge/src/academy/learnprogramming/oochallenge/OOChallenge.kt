package academy.learnprogramming.oochallenge

open class KotlinBicycle(var cadence: Int, var speed: Int, var gear: Int) {
    fun applyBrake(decrement: Int) {
        speed -= decrement
    }


    fun speedUp(increment: Int) {
        speed += increment
    }

    open fun printDescription() {
        println("Bike is in gear $gear with a cadence of $cadence travelling at a speed of $speed.")
    }

}

class KotlinMountainBike(var seatHeight: Int, cadence: Int, speed: Int, gear: Int) : KotlinBicycle(cadence, speed, gear) {
    override fun printDescription() {
        super.printDescription()
        println("The mountain bike has a seat height of $seatHeight inches.")
    }
}

class KotlinRoadBike(cadence: Int, speed: Int, gear: Int, val tireWidth: Int) : KotlinBicycle(cadence, speed, gear) {
    override fun printDescription() {
        super.printDescription()
        println("The road bike has a tire width of $tireWidth mm.")
    }
}