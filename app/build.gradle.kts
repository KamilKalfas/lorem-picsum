plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
    id("kotlin-parcelize")
}

apply(from = "$rootDir/config/quality.gradle.kts")

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
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        dataBinding = true
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.2.0-beta01"
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
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${GradleConfig.Version.Kotlin}")
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:1.1.5")
    // kotlin end

    val compose_version = "1.2.0-beta01"
    // jetpack compose start
    implementation("androidx.compose.ui:ui:$compose_version")
    implementation("androidx.compose.ui:ui-tooling:$compose_version")
    debugImplementation("androidx.compose.ui:ui-tooling-preview:$compose_version")
    implementation("androidx.compose.foundation:foundation:$compose_version")
    implementation("androidx.compose.material:material:$compose_version")
    implementation("androidx.compose.material:material-icons-core:$compose_version")
    implementation("androidx.compose.material:material-icons-extended:$compose_version")
    implementation("androidx.compose.runtime:runtime-livedata:$compose_version")
    implementation("androidx.compose.animation:animation:$compose_version")
    // jetpack compose end

    // androidx start
    implementation("androidx.activity:activity-compose:1.5.0")
    implementation("androidx.core:core-ktx:1.9.0-alpha05")
    implementation("androidx.appcompat:appcompat:Version 1.5.0-alpha01")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    implementation("androidx.navigation:navigation-fragment-ktx:2.5.0-rc02")
    implementation("androidx.navigation:navigation-ui-ktx:2.5.0-rc02")
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
