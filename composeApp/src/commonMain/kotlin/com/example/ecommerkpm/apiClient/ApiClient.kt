package com.example.ecommerkpm.apiClient

import com.seiko.imageloader.util.isGif
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

val httpClient = HttpClient {
    install(ContentNegotiation){
        json(Json {
            prettyPrint = true
            ignoreUnknownKeys = true
        })
    }
}