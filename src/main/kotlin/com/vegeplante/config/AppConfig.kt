package com.vegeplante.config

import io.ktor.application.Application
import io.ktor.server.engine.ApplicationEngineEnvironment

fun Application.getConnector() =
    (environment as ApplicationEngineEnvironment).connectors.first()

fun Application.findProperty(property: String) =
    environment.config.property(property).getString()