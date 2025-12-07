import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties
import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)

    id ("kotlin-kapt")
    id ("com.google.dagger.hilt.android")
}
android {
    namespace = "com.example.consumeapiwithapikey"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.example.consumeapiwithapikey"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        val properties =  Properties()
        properties.load(project.rootProject.file("local.properties").inputStream())

        buildConfigField("String", "API_KEY", "\"${properties.getProperty("API_KEY")}\"")
    }

//    val localProperties = Properties()
//    val localPropertiesFile = File(rootDir, "local.properties")
//    if(localPropertiesFile.exists() && localPropertiesFile.isFile){
//        localPropertiesFile.inputStream().use {
//            localProperties.load(it)
//        }
//    }
//




    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
//        debug{
//            buildConfigField("String","API_KEY", localProperties.getProperty("API_KEY"))
//        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    kapt { correctErrorTypes = true}
}

dependencies {

    // hiltViewModel()
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")

    //Viewmodel Compose
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.7")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.8.7")  // For StateFlow integration
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.4")

    // Retrofit -> Network
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")

    //OkHttp
    implementation("com.squareup.okhttp3:okhttp:4.12.0")

    //GSON
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("com.squareup.retrofit2:converter-gson:2.10.0")


    //Glide
    implementation("com.github.bumptech.glide:glide:4.16.0")

    //Hilt
    implementation("com.google.dagger:hilt-android:2.51.1")
    kapt("com.google.dagger:hilt-android-compiler:2.51.1")


    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
}