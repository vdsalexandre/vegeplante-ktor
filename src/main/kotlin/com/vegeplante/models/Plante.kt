package com.vegeplante.models

import org.jetbrains.exposed.dao.id.IntIdTable

object Plante: IntIdTable(columnName = "id_plante") {
    val nomPlante = varchar("nom_plante", 50)
    val tolereSallinite = bool("tolere_sallinite")
}