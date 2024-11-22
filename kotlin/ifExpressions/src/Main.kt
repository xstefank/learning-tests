import java.math.BigDecimal

fun main() {

//    val someCondition = 69 < 22
//    val num = if (someCondition) 50 else 492
//
//    val num2 = if (someCondition) {
//        println("sth")
//        50
//    } else {
//        println("sth else")
//        4353
//    }
//    println(num2)

//    val num = 100
//
//    when (num) {
//        in 100..199 -> println("100")
//        200 -> println("200")
//        300 -> println("300")
//        else -> println("no match")
//    }
//
//    val y = 100
//
//    when (num) {
//        in 100..199 -> println("100")
//        200 -> println("200")
//        300 -> println("300")
//        else -> println("no match")
//    }

//    val obj1: Any = "string"
//    val obj2: Any = BigDecimal.valueOf(100)
//    val obj3: Any = 42
//
//    val something = obj2
//
//    val z = when (something) {
//        is String -> {
//            println(something.uppercase())
//            1
//        }
//        is BigDecimal -> {
//            println(something.remainder(BigDecimal(10.5)))
//            2
//        }
//        is Int -> {
//            println("${something - 22}")
//            3
//        }
//        else -> {
//            println("nothing")
//            4
//        }
//    }
//
//    println(z)
//
//    val time = Season.WINTER
//
//    val num = 100
//    val num2 = -59
//    when {
//        num < num2 -> println("less")
//        num > num2 -> println("great")
//        num == num2 -> println("equal")
//
//    }

    println(getNumber("22.5") ?: throw IllegalArgumentException("number not int"))

}

fun getNumber(str: String): Int? {
    return try {
        Integer.parseInt(str)
    } catch (e: NumberFormatException) {
        null
    } finally {
        println("finally")
    }

}

enum class Season {
    SPRING, SUMMER, FALL, WINTER
}