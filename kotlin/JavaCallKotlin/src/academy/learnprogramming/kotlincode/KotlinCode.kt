//@file:JvmName("KotlinStuff")

package academy.learnprogramming.kotlincode

fun sayHelloToJava(name: String) {
    println("Kotlin says hello to Java and $name")
}

object Challenge {
    //    @JvmStatic fun doMath(x: Int, y: Int) = (x + y) * (x - y)
    fun doMath(x: Int, y: Int) = (x + y) * (x - y)
}

//class Employee(val firstName: String, val lastName: String, @JvmField var startYear: Int) {
class Employee(val firstName: String, val lastName: String, var startYear: Int) {


    @JvmOverloads
    fun takesDefault(parm1: String, parm2: String = "default") {
        println("$parm1 and $parm2")
    }

}