package com.vegeplante.config

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.ktor.application.Application
import org.jetbrains.exposed.sql.Database

fun Application.init() {
    Database.connect(
        HikariDataSource(
            HikariConfig().apply {
                schema = findProperty("ktor.datasource.schema")
                jdbcUrl = findProperty("ktor.datasource.url")
                driverClassName = findProperty("ktor.datasource.driverClassName")
                username = findProperty("ktor.datasource.username")
                password = findProperty("ktor.datasource.password")
            }
        )
    )
}
