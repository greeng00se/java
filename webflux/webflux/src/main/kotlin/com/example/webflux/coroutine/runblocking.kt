package com.example.webflux.coroutine

import kotlinx.coroutines.runBlocking

fun main() {

    runBlocking {
        println("Hello")
        println(Thread.currentThread().name)
    }

    println("world")
    println(Thread.currentThread().name)
}
