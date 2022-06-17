import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.21"
    `java-gradle-plugin`
    `maven-publish`
    id("org.jlleitschuh.gradle.ktlint") version "10.3.0"
}

group = "com.flexicondev"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

ktlint {
    version.set("0.45.2")
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.2")

    val retrofitVersion = "2.9.0"
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-gson:$retrofitVersion")

    testImplementation(kotlin("test"))
}

gradlePlugin {
    plugins {
        create("weatherBuildPlugin") {
            id = "com.flexicondev.weather"
            implementationClass = "com.flexicondev.weather.WeatherBuildPlugin"
        }
    }
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}
