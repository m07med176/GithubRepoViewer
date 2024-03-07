import java.util.Properties

@Suppress("DSL_SCOPE_VIOLATION")
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
            isMinifyEnabled = false
            isDebuggable = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
            buildConfigField("String", "BASE_URL", "\"${properties["DEBUG_URL"]}\"")
        }
        release {
            isMinifyEnabled = false
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
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

    implementation(libs.core)
    val composeBom = platform(libs.androidx.compose.bom)

    implementation(composeBom)
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






    // Paging 3
    implementation(libs.androidx.paging.runtime.ktx)
    implementation(libs.androidx.paging.compose)
    implementation(libs.room.paging)

    // Room
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    kapt(libs.androidx.room.compiler)

    // Hilt Dependency Injection
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    kapt(libs.androidx.hilt.compiler)
    implementation(libs.androidx.hilt.work)


    // Retrofit
    implementation (libs.retrofit2)
    implementation (libs.retrofit2.gson)
    implementation (libs.retrofit2.logging)


    // Worker
    implementation(libs.workManager)

    // Coil
    implementation (libs.coil)
    implementation (libs.coil.compose)

    // Lottie
    implementation(libs.ui.lottie.compose)

    // Accompanist
    implementation(libs.accompanist.pager)
    implementation(libs.accompanist.insets)
    implementation(libs.accompanist.systemuicontroller)
    implementation (libs.accompanist.swiperefresh)

    // Markdown
    implementation(libs.compose.markdown)

    // Sweet Toast
    implementation("com.github.tfaki:ComposableSweetToast:1.0.0")

    // Datastore
    implementation(libs.androidx.datastore.preferences)

    // #---------------------------------------------------------------#

    // Depugging
    // Tooling
    debugImplementation(libs.androidx.compose.ui.tooling)
    // #---------------------------------------------------------------#

    // Instrumented tests
    androidTestImplementation(composeBom)
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    androidTestImplementation(libs.androidx.test.core)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.androidx.test.runner)
    androidTestImplementation (libs.espresso.core)
    androidTestImplementation (libs.test.core.testing)
    androidTestImplementation (libs.test.coroutineTest)
    androidTestImplementation (libs.androidx.espresso.contrib)
    androidTestImplementation (libs.core.ktx)
    androidTestImplementation (libs.rules)
    androidTestImplementation (libs.runner)
    // #---------------------------------------------------------------#

    // Local tests

    // Mokito
    implementation(libs.test.mockito)
    implementation(libs.test.mockitoAndroid)
    implementation(libs.androidx.test.runner)
    // DI
    testImplementation(libs.hilt.android.testing)

    testImplementation(libs.junit)
    // Test Coroutine
    implementation(libs.test.coroutineTest)
    // #---------------------------------------------------------------#



}