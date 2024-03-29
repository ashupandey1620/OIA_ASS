plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.ashutosh.openinapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.ashutosh.openinapp"
        minSdk = 26
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
                getDefaultProguardFile("proguard-android-optimize.txt") ,
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

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")





    //Constraint Layout Compose
    implementation ("androidx.constraintlayout:constraintlayout-compose:1.0.1")


    //Mobile UI Controller Background
    implementation ("com.google.accompanist:accompanist-systemuicontroller:0.20.0")


    //Bottom sheet dialog compose
    implementation ("com.holix.android:bottomsheetdialog-compose:1.4.0")


    //Retrofit and LifeCycle Livedata Support for the ViewModels
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.google.code.gson:gson:2.9.0")
    implementation ("androidx.lifecycle:lifecycle-viewmodel:2.3.1")
    implementation ("androidx.lifecycle:lifecycle-livedata:2.3.1")


    //okhttp Network logging interceptor
    implementation ("com.squareup.okhttp3:logging-interceptor:4.12.0")


    //Navigation
    implementation ("androidx.navigation:navigation-compose:2.6.0")
    implementation ("androidx.hilt:hilt-navigation-compose:1.0.0")


    //lottie Animations JSON support
    implementation ("com.airbnb.android:lottie-compose:6.0.0")


    //Pager Support in App for Onboarding Screen
    implementation ("com.google.accompanist:accompanist-pager:0.27.0")


    implementation("com.google.dagger:hilt-android:2.44")
    kapt("com.google.dagger:hilt-android-compiler:2.44")

    //LiveData
    implementation ("androidx.compose.runtime:runtime-livedata:1.2.0-beta01")

    // ViewModel
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")


    // ViewModel utilities for Compose
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")

    //Coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.0")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.0")


    //Datastore Preferences
    implementation ("androidx.datastore:datastore-preferences:1.0.0")

    // Work Manager Library Android
    implementation ("androidx.work:work-runtime-ktx:2.9.0")

    // Hilt for work Manager
    implementation ("androidx.hilt:hilt-work:1.1.0")

    //coil Library for compose
    implementation("io.coil-kt:coil-compose:2.4.0")

    //Github Fancy Toast
    implementation ("io.github.shashank02051997:FancyToast:2.0.2")


    implementation ("co.yml:ycharts:2.1.0")



}