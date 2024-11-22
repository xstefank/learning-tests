package io.xstefank.datatypes

import io.xstefank.javacode.Dummy

fun main() {
    val myInt = 10
    var myLong = 22L

    myLong = myInt.toLong()

    val myByte: Byte = 111
    var myShort: Short
    myShort = myByte.toShort()

    var myDouble = 22.0
    println(myDouble is Double)

    var myFloat = 22.0f
    println(myFloat is Float)

    myDouble = myFloat.toDouble()

    val char = 'b'
    val myCharInt = 65
    println(myCharInt.toChar())

    val onVacation = false
    val dummy = Dummy().isVacationTime(onVacation)
    println(dummy)

    val anything: Any
    }