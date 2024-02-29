plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.mvvmecommercecompseapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.mvvmecommercecompseapp"
        minSdk = 24
        targetSdk = 33
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
        debug {
            buildConfigField("String", "IMGUR_CLIENT_ID", "\"d1168a336423c3a\"")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    testImplementation("io.mockk:mockk:1.13.10")
    testImplementation("org.mockito:mockito-core:5.10.0")
    androidTestImplementation("io.mockk:mockk-android:1.13.10")
    testImplementation("app.cash.turbine:turbine:0.7.0")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.2.0")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    //Arrow Core includes types like Either, Option, and Try that help you handle operations that can result in errors more elegantly than just throwing exceptions.
    // Arrow
    implementation("io.arrow-kt:arrow-core:1.2.0")
    // This library extends the capabilities of Arrow Core with utilities for asynchronous programming using Kotlin coroutines
    implementation("io.arrow-kt:arrow-fx-coroutines:1.2.0")
    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    //Coil
    //Coil (Coil-kt) is an image loading library for Android backed by Kotlin coroutines. This particular dependency is for integrating Coil with Jetpack Compose, allowing you to load and display images from various sources easily within your composable functions
    implementation("io.coil-kt:coil-compose:2.5.0")
    //dagger hilt
    // Hilt is a dependency injection library for Android that reduces the boilerplate of doing manual dependency injection in your project.
    implementation("com.google.dagger:hilt-android:2.44")
    // This is the kapt (Kotlin annotation processing tool) compiler plugin for Hilt. It processes the annotations in your project to generate the necessary code for Hilt's dependency injection.
    kapt("com.google.dagger:hilt-android-compiler:2.44")
    //This library provides support for injecting dependencies into composables in applications using Jetpack Compose and Hilt.
    implementation("androidx.hilt:hilt-navigation-compose:1.1.0")
    // collectAsStateWithLifeCycle
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.6.2")
}