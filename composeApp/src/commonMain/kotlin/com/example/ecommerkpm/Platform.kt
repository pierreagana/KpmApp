package com.example.ecommerkpm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform