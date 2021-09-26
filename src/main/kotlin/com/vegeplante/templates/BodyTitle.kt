package com.vegeplante.templates

import kotlinx.html.BODY
import kotlinx.html.h1

fun BODY.bodyTitle() {
    h1 { +"Liste des plantes :" }
}