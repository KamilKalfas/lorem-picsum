package com.buildsrc

object GradleConfig {
    const val Android_Gradle = "com.android.tools.build:gradle:${Version.Android_Gradle}"
    const val Kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.Kotlin}"
    const val Detekt = "io.gitlab.arturbosch.detekt:detekt-gradle-plugin:${Version.Detekt}"
    const val NavSafeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:${Version.Nav_Safe_Args}"

    object Version {
        const val Android_Gradle = "7.1.3"
        const val Kotlin = "7.1.3"
        const val Detekt = "7.1.3"
        const val Nav_Safe_Args = "7.1.3"
    }
}
