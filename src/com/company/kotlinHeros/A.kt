package com.company.kotlinHeros

import java.util.*

class A {
    var scanner = Scanner(System.`in`)

    fun main(args: Array<String>) {
        val tc = scanner.nextInt()
        for (i in 0 until tc) {
            var ans: Long = 0
            val x = scanner.nextLong()
            var y = scanner.nextLong()
            var counter: Long = 1000000000
            while (counter > 0) {
                while (y - x * counter >= 0) {
                    ans++
                    y -= x * counter
                }
                counter /= 10
            }
            ans += y
            println(ans)
        }
    }
}