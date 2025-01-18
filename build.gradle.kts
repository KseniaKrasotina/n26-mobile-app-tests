plugins {
    java
    id("io.qameta.allure") version "2.11.1"
}

repositories {
    mavenCentral()
    google()
    gradlePluginPortal()
}

dependencies {
    testImplementation("io.appium:java-client:8.5.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.2")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.9.2")
    testImplementation("org.seleniumhq.selenium:selenium-java:4.8.1")

    // JSON handling
    implementation("com.google.code.gson:gson:2.11.0")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.18.2")

    // HTTP client
    implementation("org.apache.httpcomponents.client5:httpclient5:5.4.1")
    implementation("org.apache.commons:commons-lang3:3.17.0")

    implementation("org.slf4j:slf4j-api:2.0.16")
    implementation("ch.qos.logback:logback-classic:1.2.11")

    implementation("com.aventstack:extentreports:5.0.9")
//    implementation("io.appium:java-client:8.3.0")
//    runtimeOnly("ch.qos.logback:logback-classic:1.2.11")

    testImplementation("io.qameta.allure:allure-testng:2.22.0")
    testImplementation("io.qameta.allure:allure-java-commons:2.22.0")
    implementation("io.qameta.allure.gradle.allure:allure-plugin:2.11.2")
    testImplementation("junit:junit:4.12")
}

allure {
    version.set("2.22.0")
    adapter {
        aspectjWeaver.set(true)
        frameworks {
            junit5 {
                adapterVersion.set("2.22.0")
            }
        }
    }
}

tasks.test {
    useJUnitPlatform()
}

