package com.vegeplante

import com.vegeplante.config.init
import com.vegeplante.routes.plantesConfig
import com.vegeplante.routes.staticConfig
import com.vegeplante.utils.ConfigData.API_URL
import com.vegeplante.utils.ConfigData.PROTOCOL
import io.ktor.application.Application
import io.ktor.application.log
import io.ktor.routing.routing
import io.ktor.server.engine.ApplicationEngineEnvironment

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    init(environment)

    routing {
        staticConfig()
        plantesConfig()
        val connector = getEnvironmentConnector()
        log.info("Find all plants here : $PROTOCOL${connector.host}:${connector.port}$API_URL/all")
    }
}

private fun Application.getEnvironmentConnector() =
    (environment as ApplicationEngineEnvironment).connectors.first()
