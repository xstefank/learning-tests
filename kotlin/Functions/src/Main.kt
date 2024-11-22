fun main() {
//    println(labelMultiply(label = "asdfasdf: ", op2 = 3, op1 = 4))
//
//    val emp = Employee("Jane")
//    println(emp.upperCaseFirstName())
//
//    val car1 = Car("blue", "Toyota", 2015)
//    val car2 = Car("red", "Ford", 2016)
//    val car3 = Car("gray", "Ford", 2017)
//
//    printColor(car1, car2, car3)
//
//    val manyCars = arrayOf(car1, car2, car3)
//    printColor(*manyCars)
//
//    val moreCars = arrayOf(car2, car3)
//    val car4 = car2.copy()
//    val lotsOfCar = arrayOf(*manyCars, *moreCars, car4)
//    for (c in lotsOfCar) {
//        println(c)
//    }

    println("this is all in lowercase".upperFirstAndLast())
}

fun String.upperFirstAndLast(): String {
    val upperFirst = substring(0, 1).uppercase() + substring(1)
    return upperFirst.substring(0, upperFirst.length - 1) +
            upperFirst.substring(upperFirst.length - 1, upperFirst.length).uppercase()
}


inline fun labelMultiply(op1: Int, op2: Int, label: String = "The answer is:") = "$label ${op1 * op2}"

class Employee(val firstName: String) {

    fun upperCaseFirstName() = firstName.uppercase()
}

data class Car(val color: String, val model: String, val year: Int) {}

fun printColor(vararg cars: Car) {
    for (c in cars) {
        println(c.color)
    }
}
