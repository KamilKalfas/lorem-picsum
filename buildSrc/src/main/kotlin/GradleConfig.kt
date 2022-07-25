object GradleConfig {
    const val AndroidGP = "com.android.tools.build:gradle:${Version.Android_Gradle}"
    const val KotlinGP = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.Kotlin}"
    const val SafeArgsGP =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Version.Nav_Safe_Args}"
    const val KotlinSerialization = "org.jetbrains.kotlin:kotlin-serialization:${Version.Kotlin}"
    const val HiltPlugin = "com.google.dagger:hilt-android-gradle-plugin:${Version.Hilt}"

    object QualityDependencies {
        const val ktlint = "com.pinterest:ktlint:${Version.Ktlint}"
        const val detekt = "io.gitlab.arturbosch.detekt:detekt-cli:${Version.Detekt}"
    }

    object Version {
        const val Android_Gradle = "7.2.1"
        const val Kotlin = "1.6.21"
        const val Detekt = "1.20.0-RC1"
        const val Ktlint = "0.45.1"
        const val Nav_Safe_Args = "2.5.0-rc02"
        const val Hilt = "2.42"
    }

    object Project {
        const val compileSdk = 31
        const val minSdk = 26
        const val targetSdk = 30
        const val versionCode = 1
        const val versionName = "1.0"
        const val applicationId = "com.kkalfas.lorempicsum"
        const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}
