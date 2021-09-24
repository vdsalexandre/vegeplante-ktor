package com.vegeplante

import com.vegeplante.config.init
import com.vegeplante.routes.plantesConfig
import io.ktor.application.Application
import io.ktor.routing.routing

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    init(environment)

    routing {
        plantesConfig()
    }
}
