// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(id = "com.android.application") version "8.2.2" apply false
    id(id = "org.jetbrains.kotlin.android") version "1.8.0" apply false
    id(id = "com.google.dagger.hilt.android") version "2.48" apply false
    id(id = "com.android.library") version "8.2.2" apply false
    id(id = "org.jetbrains.kotlin.jvm") version "1.9.0" apply false
}

buildscript {
    dependencies {
        classpath(dependencyNotation = "com.android.tools.build:gradle:8.2.2")
        classpath(dependencyNotation = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.21")
        classpath(dependencyNotation = "com.google.dagger:hilt-android-gradle-plugin:2.48.1")
    }

    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()

        maven(url = "https://jitpack.io")
        maven(url = "https://maven.google.com")
        maven(url = "https://developer.huawei.com/repo/")
    }
}