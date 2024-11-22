package io.xstefank

import java.time.Year

fun topLevel(str: String) = println("top level function: $str")

fun main() {
    topLevel("I'm private")
}

object CompanyCommunication {

    val currerntYear = Year.now().value

    fun getTagLine() = "Our company rocks!"
    fun getCopyrightLine() = "Copyright \u00A9 $currerntYear Our Company. All rights reserved."
}

class SomeClass private constructor(val someString: String) {

    companion object {
        private var privateVar = 6

        fun accessPrivateVar() = "PrivateVar: $privateVar"

        fun justAssing(str: String) = SomeClass(str)
        fun upperOrLowerCase(str: String, lowerCase: Boolean): SomeClass {
            return if (lowerCase) {
                SomeClass(str.lowercase())
            } else {
                SomeClass(str.uppercase())
            }
        }
    }
}

interface SomeInterface {
    fun mustImplement(num: Int): String
}

fun wantsSomeInterface(si: SomeInterface) {
    println("Printing from wantsSomeInterface ${si.mustImplement(22)}")
}

enum class Department(val fullName: String, val numEmployees: Int) {
    HR("Human Resource", 5),
    IT("Information Technology", 10),
    ACCOUNTING("Accounting", 4),
    SALES("Sales", 20);

    fun getDeptInfo() = "The $fullName department has $numEmployees employees"
}

fun String.upperFirstAndLast(): String {
    val upperFirst = substring(0, 1).uppercase() + substring(1);
    return upperFirst.substring(0, upperFirst.length - 1) + upperFirst.substring(upperFirst.length - 1).uppercase()
}