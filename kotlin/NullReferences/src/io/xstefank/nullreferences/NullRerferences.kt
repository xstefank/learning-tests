package io.xstefank.nullreferences

fun main() {
//    val str: String? = null
//    str?.let { println(it) }
//
//    val str4: String? = null
//    val anotherStr = "This isn't a nullable"
//    println(str4 == anotherStr)
//
//    val str2 = str!!
//    val str3 = str2.uppercase()

    val nullableInts = arrayOfNulls<Int>(5)
    for (i in nullableInts) {
        println(i)
    }

    println(nullableInts[3].toString())
}

fun printText(text: String) {
    println(text)
}