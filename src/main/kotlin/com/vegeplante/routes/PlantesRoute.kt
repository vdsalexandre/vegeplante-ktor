package com.vegeplante.routes

import com.vegeplante.models.Plante
import io.ktor.application.call
import io.ktor.html.respondHtml
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.route
import kotlinx.html.body
import kotlinx.html.h1
import kotlinx.html.head
import kotlinx.html.li
import kotlinx.html.title
import kotlinx.html.ul
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

fun Route.plantesConfig() {
    route("/plantes") {

        get("/all") {
            call.respondHtml {
                head {
                    title { +"Vegeplante" }
                }
                body {
                    h1 { +"Liste des plantes :" }
                    ul {
                        transaction {
                            for (plante in Plante.selectAll()) {
                                li { +plante[Plante.nomPlante] }
                            }
                        }
                    }
                }
            }
        }
    }
}