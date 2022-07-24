plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
    id("kotlin-parcelize")
}

apply(from = "$rootDir/config/quality.gradle.kts")

android {
    compileSdk = GradleConfig.Project.compileSdk

    defaultConfig {
        minSdk = GradleConfig.Project.minSdk
        targetSdk = GradleConfig.Project.targetSdk
        versionCode = GradleConfig.Project.versionCode
        versionName = GradleConfig.Project.versionName
        applicationId = GradleConfig.Project.applicationId
        testInstrumentationRunner = GradleConfig.Project.testInstrumentationRunner
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
        freeCompilerArgs = listOf("-opt-in=kotlin.RequiresOptIn")
    }

    buildFeatures {
        dataBinding = true
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.2.0-beta01"
    }

    packagingOptions {
        // Multiple dependency bring these files in. Exclude them to enable
        // our test APK to build (has no effect on our AARs)
        resources.excludes.add("/META-INF/AL2.0")
        resources.excludes.add("/META-INF/LGPL2.1")
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

    val composeVersion = "1.2.0-beta01"
    // jetpack compose start
    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation("androidx.compose.ui:ui-tooling:$composeVersion")
    debugImplementation("androidx.compose.ui:ui-tooling-preview:$composeVersion")
    implementation("androidx.compose.foundation:foundation:$composeVersion")
    implementation("androidx.compose.material:material:$composeVersion")
    implementation("androidx.compose.material:material-icons-core:$composeVersion")
    implementation("androidx.compose.material:material-icons-extended:$composeVersion")
    implementation("androidx.compose.runtime:runtime-livedata:$composeVersion")
    implementation("androidx.compose.animation:animation:$composeVersion")
    // jetpack compose end

    // Accompanist
    val accompanistVersion = "0.24.9-beta"
    implementation("com.google.accompanist:accompanist-navigation-animation:0.23.1")
    implementation("com.google.accompanist:accompanist-systemuicontroller:$accompanistVersion")
    implementation("com.google.accompanist:accompanist-swiperefresh:$accompanistVersion")
    implementation("com.google.accompanist:accompanist-insets-ui:$accompanistVersion")

    // coil start
    implementation("io.coil-kt:coil-compose:2.1.0")
    // coil end

    // androidx start
    implementation("androidx.activity:activity-compose:1.5.0")
    implementation("androidx.core:core-ktx:1.8.0")
    implementation("androidx.appcompat:appcompat:1.5.0-alpha01")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    implementation("androidx.navigation:navigation-fragment-ktx:2.5.0-rc02")
    implementation("androidx.navigation:navigation-ui-ktx:2.5.0-rc02")
    // androidx end

    // google start
    implementation("com.google.android.material:material:1.6.1")
    // google end

    // ktor
    val ktorVersion = "2.0.3"
    implementation("io.ktor:ktor-client-core:$ktorVersion")
    implementation("io.ktor:ktor-client-android:$ktorVersion")
    implementation("io.ktor:ktor-client-serialization:$ktorVersion")
    implementation("io.ktor:ktor-client-logging:$ktorVersion")
    implementation("io.ktor:ktor-client-auth:$ktorVersion")

    implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
    implementation("io.ktor:ktor-serialization-gson:2.0.0")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")


    // third parties start
    implementation("com.jakewharton.timber:timber:5.0.1")
    // third parties end

    // test start
    testImplementation("junit:junit:4.13.2")
    testImplementation("io.ktor:ktor-client-mock:$ktorVersion")
    // test end

    // androidTest start
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.navigation:navigation-testing:2.4.2")
    // androidTest end
}
