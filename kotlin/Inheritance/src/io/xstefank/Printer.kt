package io.xstefank

fun main() {
//    val laserPrinter = LaserPrinter("Brother 1234", 15)
//    laserPrinter.printModel()
//
//    SomethingElse("whatever")

    println(CompanyCommunication.getTagLine())
    println(CompanyCommunication.getCopyrightLine())

    println(SomeClass.accessPrivateVar())
    val sc1 = SomeClass.justAssing("whatever")
    val sc2 = SomeClass.upperOrLowerCase("whatever to be uppercase", false)
    println(sc1.someString)
    println(sc2.someString)

    var thisIsMutable = 45

    wantsSomeInterface(object: SomeInterface {
        override fun mustImplement(num: Int): String {
            thisIsMutable++
            return "This is from mustImplement: ${num * 100}"
        }
    })

    println(thisIsMutable)

    println(Department.ACCOUNTING.getDeptInfo())
}

abstract class Printer(val modelName: String) {

    open fun printModel() = println("The model name of this printer is $modelName")
    abstract fun bestSellingPrice(): Double

}

open class LaserPrinter(modelName: String, ppm: Int) : Printer(modelName) {

    final override fun printModel() = println("The model name of this laser printer is $modelName")
    override fun bestSellingPrice(): Double = 129.99
}

class SpecialLaserPrinter(modelName: String, ppm: Int) : LaserPrinter(modelName, ppm) {

}

open class Something: MyuSubInterface {

    val someProperty: String
    override val number: Int = 25

    constructor(someProperty: String) {
        this.someProperty = someProperty
        println("I'm in the parent's constructor")
    }

    override fun mySubFunction(num: Int): Int {
        TODO()
    }

    override fun myFunction(str: String): String {
        TODO("Not yet implemented")
    }
}

class SomethingElse : Something {
    constructor(someOtherProperty: String) : super(someOtherProperty) {
        println("I'm in the childs's constructor")
    }
}

interface MyInterface {

    val number: Int
    val number2: Int
        get() = number * 100

    fun myFunction(str: String): String
}

interface MyuSubInterface: MyInterface {

    fun mySubFunction(num: Int): Int

}