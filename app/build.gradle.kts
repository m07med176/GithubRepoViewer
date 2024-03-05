@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.dagger.hilt.android)
    kotlin("kapt")
}

android {
    namespace = "tech.vodafone.githuprepoviewer"
    compileSdk = 34

    defaultConfig {
        applicationId = "tech.vodafone.githuprepoviewer"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.ui)
    implementation(libs.core.ktx)
    testImplementation(libs.junit)
    implementation(libs.material3)
    implementation(libs.ui.graphics)
    debugImplementation(libs.ui.tooling)
    implementation(libs.activity.compose)
    implementation(libs.ui.tooling.preview)
    debugImplementation(libs.ui.test.manifest)
    implementation(platform(libs.compose.bom))
    implementation(libs.lifecycle.runtime.ktx)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(libs.ui.test.junit4)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.androidx.test.ext.junit)

    // Dagger Hilt
    kapt(libs.hilt.compiler)
//    kapt(libs.androidx.hilt.compiler)
    implementation(libs.hilt.work)
    implementation(libs.hilt.android)
//    implementation(libs.hilt.navigation.compose)

    // Retrofit
    implementation (libs.retrofit2)
    implementation (libs.retrofit2.gson)
    implementation (libs.retrofit2.logging)

    // Room
//    implementation(libs.room.ktx)
//    implementation(libs.room.runtime)
//    implementation(libs.room.compiler)

    // Worker
    implementation(libs.workManager)

    // Coil
    implementation (libs.coil)
    implementation (libs.coil.compose)

//     Accompanist
    implementation(libs.accompanist.pager)
    implementation(libs.accompanist.insets)
}