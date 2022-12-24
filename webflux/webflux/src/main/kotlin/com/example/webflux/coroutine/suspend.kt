package com.example.webflux.coroutine

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

suspend fun main() {
    doSomething()
}

fun printHello() = println("Hello")

suspend fun doSomething() = coroutineScope {

    launch {
        delay(200)
        println("world")
    }

    launch {
        printHello()
    }
}
