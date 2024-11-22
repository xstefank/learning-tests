
val MY_CONSTANT = 100

fun main() {

//    println(MY_CONSTANT)
//
//    val emp = Employee("John")
//    println(emp.firstName)
//    emp.fullTime = false
//    println(emp.fullTime)
//
//    val emp2 = Employee("Joe")
//    println(emp2.firstName)
//    println(emp2.fullTime)
//
//    val emp3 = Employee("Jane", false)
//    println(emp3.firstName)
//    println(emp3.fullTime)
//
//    println(Demo().dummy)

    val car = Car("blue", "Toyota", 2015)
    println(car)
    val car2 = Car("blue", "Toyota", 2015)
    println(car == car2)
    val car3 = car.copy()
    println(car3)
    val car4 = car.copy(year = 2016, color = "green")
    println(car4)

}

data class Car(val color: String, val model: String, val year: Int) {}

class Employee(val firstName: String, fullTime: Boolean = true) {

    var fullTime = fullTime
        get() {
            println("Full Time : $field")
            return field
        }
        set(value) {
            println("SET Full Time : $value")
            field = value
        }

}

class Demo {
    val dummy: String

    constructor() {
        dummy = "Hello"
    }
}