package com.vegeplante.routes

import com.vegeplante.models.Plante
import com.vegeplante.templates.header
import io.ktor.application.call
import io.ktor.html.respondHtml
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.route
import kotlinx.html.body
import kotlinx.html.h1
import kotlinx.html.table
import kotlinx.html.tbody
import kotlinx.html.td
import kotlinx.html.th
import kotlinx.html.thead
import kotlinx.html.tr
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

fun Route.plantesConfig() {
    route("/plantes") {

        get("/all") {
            call.respondHtml {
                header(title = "Vegeplante", css = "/style.css")
                body {
                    h1 { +"Liste des plantes :" }
                    table {
                        thead {
                            tr {
                                th { +"Id plante" }
                                th { +"Nom Plante" }
                                th { +"Tollere sallinite" }
                            }
                        }
                        tbody {
                            transaction {
                                for (plante in Plante.selectAll()) {
                                    tr {
                                        td { +plante[Plante.id].toString() }
                                        td { +plante[Plante.nomPlante] }
                                        td { +Plante.getTolereSallinite() }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}