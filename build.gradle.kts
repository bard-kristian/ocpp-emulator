plugins {
    kotlin("multiplatform") version "2.0.10" apply false
    id("org.jetbrains.compose") version "1.6.11" apply false
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.10" apply false
    id("org.jlleitschuh.gradle.ktlint") version "12.1.1" apply false
    id("com.google.devtools.ksp") version "2.0.10-1.0.24" apply false
}

allprojects {
    repositories {
        mavenLocal()
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/monta-app/library-ocpp")
            credentials {
                username = System.getenv("GHL_USERNAME") ?: project.findProperty("gpr.user") as String?
                password = System.getenv("GHL_PASSWORD") ?: project.findProperty("gpr.key") as String?
            }
        }
    }
}
