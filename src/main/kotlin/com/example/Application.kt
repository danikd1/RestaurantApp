package com.example

import com.example.plugins.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.jetbrains.exposed.sql.Database

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    Database.connect(
        url = "jdbc:postgresql://postgres:5432/ktor",
        driver = "org.postgresql.Driver",
        user = "username",
        password = "secret"
    )

    configureSerialization()
    configureDatabases()
    configureHTTP()
    configureRouting()
}
