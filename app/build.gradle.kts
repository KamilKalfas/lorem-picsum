plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
    id("kotlin-parcelize")
}

android {
    compileSdk = 32

    defaultConfig {
        minSdk = 26
        targetSdk = 30
        versionCode = 1
        versionName = "1.0"
        applicationId = "com.kkalfas.lorempicsum"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        allWarningsAsErrors = true
        jvmTarget = "1.8"
    }

    buildFeatures {
        dataBinding = true
    }

    testOptions {
        with(unitTests) {
            isReturnDefaultValues = true
            isIncludeAndroidResources = true
        }
    }
}

dependencies {
    // kotlin start
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.6.21")
    // kotlin end

    // androidx start
    implementation("androidx.core:core-ktx:1.8.0")
    implementation("androidx.appcompat:appcompat:1.4.2")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    implementation("androidx.navigation:navigation-fragment-ktx:2.4.2")
    implementation("androidx.navigation:navigation-ui-ktx:2.4.2")
    // androidx end

    // google start
    implementation("com.google.android.material:material:1.6.1")
    // google end

    // third parties start
    implementation("com.github.bumptech.glide:glide:4.13.2")
    kapt("com.github.bumptech.glide:compiler:4.13.2")
    // third parties end

    // test start
    testImplementation("junit:junit:4.13.2")
    // test end

    // androidTest start
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.navigation:navigation-testing:2.4.2")
    // androidTest end
}
