package com.vegeplante.routes

import com.vegeplante.models.Plante
import com.vegeplante.templates.bodyTitle
import com.vegeplante.templates.header
import com.vegeplante.templates.listPlants
import com.vegeplante.templates.searchMenu
import com.vegeplante.utils.ConfigData.PLANTS_URL
import io.ktor.application.call
import io.ktor.html.respondHtml
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.route
import kotlinx.html.BODY
import kotlinx.html.body
import kotlinx.html.h1
import org.jetbrains.exposed.sql.LowerCase
import org.jetbrains.exposed.sql.Query
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll

fun Route.plantesConfig() {
    route(PLANTS_URL) {

        get("/all") {
            call.respondHtml {
                header(title = "Vegeplante - all", css = "/style.css")
                body {
                    bodyTitle()
                    searchMenu()
                    listPlants(query = Plante.selectAll())
                }
            }
        }

        get("/contains") {
            call.respondHtml {
                val valueToSearch = call.request.queryParameters["nameStartsWith"]?.lowercase()
                val query = if (valueToSearch.isNullOrEmpty()) {
                    Plante.selectAll()
                } else Plante.select { LowerCase(Plante.nomPlante) like "$valueToSearch%" }

                header(title = "Vegeplante - search", css = "/style.css")
                body {
                    bodyTitle()
                    searchMenu()
                    listPlants(query = query)
                }
            }
        }
    }
}
