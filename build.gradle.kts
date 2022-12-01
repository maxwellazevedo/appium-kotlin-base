buildscript {
    repositories {
        gradlePluginPortal()
    }
    dependencies {
        classpath("com.jfrog.bintray.gradle:gradle-bintray-plugin:1.8.5")
    }
}

plugins {
    kotlin("jvm") version "1.3.72"
    id("io.qameta.allure") version "2.10.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

apply(plugin = "io.qameta.allure")

dependencies {
    implementation(kotlin("stdlib"))
    implementation ("junit:junit:4.12")
    //testCompile group: 'junit', name: 'junit', version: '4.12'
    testImplementation("junit:junit:4.12")
    implementation("io.appium:java-client:6.0.0")
    testImplementation("io.qameta.allure:allure-junit4:2.10.0")

}

tasks.test {
    useJUnit()
}