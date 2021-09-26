package com.vegeplante.routes

import io.ktor.application.ApplicationCall
import io.ktor.application.call
import io.ktor.http.ContentType
import io.ktor.response.respondText
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.route
import kotlinx.css.Color
import kotlinx.css.CssBuilder
import kotlinx.css.body
import kotlinx.css.color
import kotlinx.css.margin
import kotlinx.css.padding
import kotlinx.css.td

fun Route.staticConfig() {
    route("") {
        get("/style.css") {
            call.respondCss {
                body {
                    padding = "0"
                    margin = "0"
                }
                td {
                    color = Color.red
                }
            }
        }
    }
}

suspend inline fun ApplicationCall.respondCss(builder: CssBuilder.() -> Unit) {
    this.respondText(CssBuilder().apply(builder).toString(), ContentType.Text.CSS)
}