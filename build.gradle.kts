// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {

    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    kotlin("plugin.serialization") version "1.9.0"
//    kotlin("plugin.serialization") version "2.1.0"
//    compose
//    compose-compiler = { id = "org.jetbrains.kotlin.plugin.compose", version.ref = "kotlin" }
}