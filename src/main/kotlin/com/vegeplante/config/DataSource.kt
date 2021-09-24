package com.vegeplante.config

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.ktor.application.ApplicationEnvironment
import org.jetbrains.exposed.sql.Database

fun init(environment: ApplicationEnvironment) {
    Database.connect(
        HikariDataSource(
            HikariConfig().apply {
                schema = environment.config.property("ktor.datasource.schema").getString()
                jdbcUrl = environment.config.property("ktor.datasource.url").getString()
                driverClassName = environment.config.property("ktor.datasource.driverClassName").getString()
                username = environment.config.property("ktor.datasource.username").getString()
                password = environment.config.property("ktor.datasource.password").getString()
            }
        )
    )
}