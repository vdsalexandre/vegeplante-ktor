package com.vegeplante.routes

import com.vegeplante.models.Plante
import com.vegeplante.templates.bodyTitle
import com.vegeplante.templates.head
import com.vegeplante.templates.listPlants
import com.vegeplante.templates.searchMenu
import com.vegeplante.utils.ConfigData.ALL_PLANTS_URL
import com.vegeplante.utils.ConfigData.API_URL
import com.vegeplante.utils.ConfigData.SEARCH_URL
import io.ktor.application.call
import io.ktor.html.respondHtml
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.route
import kotlinx.html.body
import org.jetbrains.exposed.sql.LowerCase
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll

fun Route.plantesConfig() {
    route(API_URL) {

        get(ALL_PLANTS_URL) {
            call.respondHtml {
                head(title = "Vegeplante - all", css = "/css/style.css")
                body {
                    bodyTitle()
                    searchMenu()
                    listPlants(query = Plante.selectAll())
                }
            }
        }

        get(SEARCH_URL) {
            call.respondHtml {
                val valueToSearch = call.request.queryParameters["nameStartsWith"]?.lowercase()
                val query = if (valueToSearch.isNullOrEmpty()) {
                    Plante.selectAll()
                } else Plante.select { LowerCase(Plante.nomPlante) like "$valueToSearch%" }

                head(title = "Vegeplante - search", css = "/css/style.css")
                body {
                    bodyTitle()
                    searchMenu()
                    listPlants(query = query)
                }
            }
        }
    }
}
