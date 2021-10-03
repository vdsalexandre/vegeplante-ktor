package com.vegeplante.templates

import com.vegeplante.utils.ConfigData.API_URL
import com.vegeplante.utils.ConfigData.SEARCH_URL
import kotlinx.html.BODY
import kotlinx.html.FormMethod
import kotlinx.html.InputType
import kotlinx.html.form
import kotlinx.html.input
import kotlinx.html.label

fun BODY.searchMenu() {
    form(method = FormMethod.get, action = "$API_URL$SEARCH_URL") {
        label {
            attributes["for"] = "searchPlants"
            +"Rechercher une ou des plantes : "
        }
        input(type = InputType.text, name = "nameStartsWith") {
            attributes["id"] = "searchPlants"
        }
        input(type = InputType.submit) { attributes["value"] = "Rechercher" }
    }
}
