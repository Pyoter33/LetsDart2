package com.pmartin.letsdart2

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform