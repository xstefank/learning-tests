package io.xstefank.anotherpackage

import io.xstefank.CompanyCommunication as Comm
import io.xstefank.topLevel as tp
import io.xstefank.Department.*

fun main() {
    tp("Hello from another file")
    println(Comm.getCopyrightLine())
    println(IT.getDeptInfo())
    println(SALES.getDeptInfo())
}