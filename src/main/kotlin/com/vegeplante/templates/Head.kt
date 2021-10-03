package com.vegeplante.templates

import kotlinx.html.HTML
import kotlinx.html.head
import kotlinx.html.styleLink
import kotlinx.html.title

fun HTML.head(title: String, css: String) {
    head {
        title { +title }
        styleLink(css)
    }
}