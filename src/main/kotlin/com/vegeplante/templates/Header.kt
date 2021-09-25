package com.vegeplante.templates

import kotlinx.html.HTML
import kotlinx.html.head
import kotlinx.html.link
import kotlinx.html.title

fun HTML.header(title: String, css: String) {
    head {
        title { +title }
        link(href = css, rel = "stylesheet", type = "text/css")
    }
}