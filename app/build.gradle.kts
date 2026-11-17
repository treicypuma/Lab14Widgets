plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose) // Reemplaza a composeOptions (compilador de Compose)
}

android {
    namespace = "com.example.lab14widgets"
    compileSdk {
        version = release(37)
    }

    defaultConfig {
        applicationId = "com.example.lab14widgets"
        minSdk = 24
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                enable = false
            }
        }
    }

    // Lab 14 - Ejercicio 1, punto 2: configuración del compilador de Compose
    buildFeatures {
        compose = true
    }

    // composeOptions { kotlinCompilerExtensionVersion = "1.5" }
    //   -> No se usa: lo cubre el plugin kotlin.compose de arriba.

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    // kotlinOptions { jvmTarget = "1.8" }
    //   -> No se usa: lo cubre compileOptions (Java 11) de arriba.
}

dependencies {
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    // Glance (Lab 14: Widgets)
    // Soporte para AppWidgets
    implementation("androidx.glance:glance-appwidget:1.1.0")
    // Interoperabilidad con Material 3
    implementation("androidx.glance:glance-material3:1.1.0")
    // Interoperabilidad con Material 2
    implementation("androidx.glance:glance-material:1.1.0")

    testImplementation(libs.junit)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
    debugImplementation(libs.androidx.compose.ui.tooling)
}