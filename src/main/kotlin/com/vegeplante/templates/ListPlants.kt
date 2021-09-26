package com.vegeplante.templates

import com.vegeplante.models.Plante
import kotlinx.html.BODY
import kotlinx.html.table
import kotlinx.html.tbody
import kotlinx.html.td
import kotlinx.html.th
import kotlinx.html.thead
import kotlinx.html.tr
import org.jetbrains.exposed.sql.Query
import org.jetbrains.exposed.sql.transactions.transaction

fun BODY.listPlants(query: Query) {
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
                for (plante in query) {
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
