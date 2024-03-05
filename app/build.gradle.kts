import java.util.Properties

@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
//plugins {
//    alias(libs.plugins.android.application)
//    alias(libs.plugins.kotlin.android)
//    alias(libs.plugins.kotlin.kapt)
//    alias(libs.plugins.hilt.gradle)
//}

plugins {
    id(id = "com.android.application")
    id(id = "kotlin-android")
    id(id = "kotlin-kapt")
    id(id = "org.jetbrains.kotlin.android")
    id(id = "dagger.hilt.android.plugin")

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
        val properties = Properties()
        properties.load(project.rootProject.file("local.properties").inputStream())

        debug {
//            isMinifyEnabled = true
            isDebuggable = true
//            proguardFiles(
//                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
//            )
            buildConfigField("String", "BASE_URL", "\"${properties["DEBUG_URL"]}\"")
        }
        release {
//            isMinifyEnabled = false
            isDebuggable = false
//            proguardFiles(
//                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
//            )
            buildConfigField("String", "BASE_URL", "\"${properties["RELEASE_URL"]}\"")
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
        buildConfig = true
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

    val composeBom = platform(libs.androidx.compose.bom)
    implementation(composeBom)
    androidTestImplementation(composeBom)

    // Core Android dependencies
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)


    // Arch Components
    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.navigation.compose)


    // Compose
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    // Tooling
    debugImplementation(libs.androidx.compose.ui.tooling)
    // Instrumented tests
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.test.manifest)

    // Local tests: jUnit, coroutines, Android runner
    testImplementation(libs.junit)
    testImplementation(libs.kotlinx.coroutines.test)

    // Instrumented tests: jUnit rules and runners

    androidTestImplementation(libs.androidx.test.core)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.androidx.test.runner)

//    implementation(libs.ui)
//    implementation(libs.core.ktx)
//    testImplementation(libs.junit)
//    implementation(libs.material3)
//    implementation(libs.ui.graphics)
//    debugImplementation(libs.ui.tooling)
//    implementation(libs.activity.compose)
//    implementation(libs.ui.tooling.preview)
//    debugImplementation(libs.ui.test.manifest)
//    implementation(platform(libs.compose.bom))
//    implementation(libs.lifecycle.runtime.ktx)
//    androidTestImplementation(libs.espresso.core)
//    androidTestImplementation(libs.ui.test.junit4)
//    androidTestImplementation(platform(libs.compose.bom))
//    androidTestImplementation(libs.androidx.test.ext.junit)

    // Dagger Hilt
//    kapt(libs.hilt.compiler)
//    kapt(libs.androidx.hilt.compiler)
//    implementation(libs.hilt.work)
//    implementation(libs.hilt.android)
//    implementation(libs.hilt.navigation.compose)


    // Room
//    implementation(libs.room.ktx)
//    implementation(libs.room.runtime)
//    implementation(libs.room.compiler)

    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    kapt(libs.androidx.room.compiler)

    // Hilt Dependency Injection
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(dependencyNotation = "com.google.dagger:hilt-android:2.48.1")
    kapt(dependencyNotation = "com.google.dagger:hilt-compiler:2.48.1")
    kapt(dependencyNotation = "androidx.hilt:hilt-compiler:1.1.0")
    implementation(dependencyNotation = "androidx.hilt:hilt-work:1.1.0")

//    implementation(libs.hilt.android)
//    kapt(libs.hilt.compiler)
    // Hilt and instrumented tests.
//    androidTestImplementation(libs.hilt.android.testing)
//    kaptAndroidTest(libs.hilt.android.compiler)
    // Hilt and Robolectric tests.
//    testImplementation(libs.hilt.android.testing)
//    kaptTest(libs.hilt.android.compiler)

    // Retrofit
//    implementation (libs.retrofit2)
//    implementation (libs.retrofit2.gson)
//    implementation (libs.retrofit2.logging)

    //Networking libraries
    implementation(dependencyNotation = "com.squareup.retrofit2:retrofit:2.9.0")
    implementation(dependencyNotation = "com.squareup.retrofit2:converter-gson:2.9.0")
    implementation(dependencyNotation = "com.google.code.gson:gson:2.10")
    implementation(dependencyNotation = "com.squareup.okhttp3:okhttp:5.0.0-alpha.5")
    implementation(dependencyNotation = "com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.5")


    // Worker
    implementation(libs.workManager)

    // Coil
    implementation (libs.coil)
    implementation (libs.coil.compose)

//     Accompanist
    implementation(libs.accompanist.pager)
    implementation(libs.accompanist.insets)
}