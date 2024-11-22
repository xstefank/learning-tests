fun main() {

    val myFloat: Float = -3847.384f
    val myFloat2 : Float
    myFloat2 = -3847.384f
    println(myFloat)
    println(myFloat2)

    val myFloat1Nullable : Float? = myFloat
    val myFloat2Nullable : Float? = myFloat2
    println(myFloat1Nullable)
    println(myFloat2Nullable)

    val shortArray = shortArrayOf(1, 2, 3, 4, 5)
    for (short in shortArray) {
        println(short)
    }

    val ints = IntArray(40) { i -> (i + 1) * 5 }
    for (int in ints) {
        println(int)
    }

    val charArray = charArrayOf('a', 'b', 'c')

    val x: String? = "I AM IN UPPERCASE"
//    val y = x?.lowercase() ?: "I give up!"
//    println(y)

    val s = x?.let { it.lowercase().replace("am", "am not") }
    println(s)

    val myNonNullVariable: Int? = null
    myNonNullVariable!!.toDouble()
}