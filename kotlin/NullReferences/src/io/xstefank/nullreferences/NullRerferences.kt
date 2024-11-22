package io.xstefank.nullreferences

fun main() {
    val str: String? = null
    println("String: ${str?.uppercase()}")

    val str2 = str ?: "This is default value"
    println("String2: ${str2.uppercase()}")

    val something: Any = arrayOf(1, 2, 3, 4)
    val str3 = something as? String
    println("String3: ${str3?.uppercase()}")
}