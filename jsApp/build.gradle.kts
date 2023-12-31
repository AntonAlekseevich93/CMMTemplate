plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

group = "com.cmmtemplate"
version = "1.0-SNAPSHOT"

repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

kotlin {
    js(IR) {
        browser {
            testTask {
                testLogging.showStandardStreams = true
                useKarma {
                    useChromeHeadless()
                    useFirefox()
                }
            }
        }
        binaries.executable()
    }
    sourceSets {
        val jsMain by getting {
            dependencies {
                implementation(compose.html.core)
                implementation(compose.runtime)
                implementation(project(":shared"))
            }
        }
        val jsTest by getting {
            dependencies {
                implementation(kotlin("test-js"))
            }
        }
    }
}

compose.experimental {
    web.application {}
}

// TODO: temporary workaround because of issue: https://github.com/JetBrains/compose-multiplatform/issues/2815
//tasks.getByName("jsBrowserDevelopmentRun").doFirst {
//    val error = "throw new NotImplementedError('An operation is not implemented: implement native toLanguageTag');"
//    val implementation = "return \"\";"
//    val file = file("../build/js/packages/CMMTemplate-jsApp/kotlin/androidx-ui-text.js")
//    val buffer = StringBuffer()
//    file.forEachLine { line ->
//        buffer.appendLine(line.replace(error, implementation))
//    }
//    file.writeText(buffer.toString())
//}