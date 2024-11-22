package io.xstefank.anothermodule

import io.xstefank.topLevel
import io.xstefank.upperFirstAndLast as ufal

fun main() {
    topLevel("Hello from another module")
    println("as string to work with".ufal())
}