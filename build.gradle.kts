val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val kotlin_css_version: String = "1.0.0-pre.248-kotlin-1.5.31"

val exposed_version: String = "0.34.1"
val junit_version: String = "5.8.1"
val assertj_version: String = "0.2.1"


plugins {
    application
    kotlin("jvm") version "1.5.30"
                id("org.jetbrains.kotlin.plugin.serialization") version "1.5.30"
}

group = "com.vegeplante"
version = "0.0.1"
application {
    mainClass.set("io.ktor.server.netty.EngineMain")
}

allprojects {
    repositories {
        mavenCentral()
    }
}

repositories {
    jcenter()
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.5.30")
    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation("io.ktor:ktor-serialization:$ktor_version")
    implementation("org.jetbrains.kotlinx:kotlinx-html-jvm:0.7.3")
    implementation("io.ktor:ktor-html-builder:$ktor_version")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-css:$kotlin_css_version")
    implementation("io.ktor:ktor-server-host-common:$ktor_version")
    implementation("io.ktor:ktor-server-netty:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    implementation("com.zaxxer:HikariCP:5.0.0")
    implementation("org.postgresql:postgresql:42.2.23")

    implementation("org.jetbrains.exposed:exposed-core:$exposed_version")
    implementation("org.jetbrains.exposed:exposed-dao:$exposed_version")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposed_version")

    testImplementation("io.ktor:ktor-server-tests:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test:$kotlin_version")
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junit_version")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:$junit_version")
    testImplementation("net.wuerl.kotlin:assertj-core-kotlin:$assertj_version")
}