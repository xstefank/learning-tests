fun main() {
//    val range = 1..5
//    for (i in range) {
//        println(i)
//    }
//
//    val charRange = 'a'..'z'
//    val strRange = "ABC".."XYZ"
//
//    println(3 in range)
//    println('q' in charRange)
//    println("CCC" in strRange)
//    println("CCCCC" in strRange)
//    println("ZZZZZ" in strRange)
//
//    val backRange = 5.downTo(1)
//    println(5 in backRange)
//
//    val stepRange = 3..15
//    val stepThree = stepRange.step(3)
//    val reversedRange = range.reversed()
//
//
//    for (n in reversedRange) {
//        println(n)
//    }
//
//    for (c in "Hello") {
//        println(c)
//    }
//
//    for (num in 1..20 step 4) {
//        println(num)
//    }
//
//    for (i in 20 downTo 10 step 5) {
//        println(i)
//    }
//
//    for (i in 1 until 10) {
//        println(i)
//    }

//    val seasons = arrayOf("spring", "summer", "winter", "fall")
//    for (index in seasons.indices) {
//        println("${seasons[index]} is season number $index")
//    }
//
//    seasons.forEach { println(it) }
//    seasons.forEachIndexed { index, value -> println("$index is $value") }
//
//    println("whatever" !in seasons)
//    println(30 !in 1..10)

    for (i in 1..3) {
        println("i = $i")
        jloop@ for (j in 1..4) {
            println("j = $j")
            for (k in 5..10) {
                println("k = $k")
                if (k == 7) {
                    break@jloop
                }
            }
        }
    }

}