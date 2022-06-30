object GradleConfig {
    const val AndroidGP = "com.android.tools.build:gradle:${Version.Android_Gradle}"
    const val KotlinGP = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.Kotlin}"
    const val DetektGP = "io.gitlab.arturbosch.detekt:detekt-gradle-plugin:${Version.Detekt}"
    const val SafeArgsGP = "androidx.navigation:navigation-safe-args-gradle-plugin:${Version.Nav_Safe_Args}"

    object QualityDependencies {
        const val ktlint = "com.pinterest:ktlint:${Version.Ktlint}"
        const val detekt = "io.gitlab.arturbosch.detekt:detekt-cli:${Version.Detekt}"
    }

    object Version {
        const val Android_Gradle = "7.1.2"
        const val Kotlin = "1.6.10"
        const val Detekt = "1.20.0-RC1"
        const val Ktlint = "0.45.1"
        const val Nav_Safe_Args = "2.5.0-rc02"
    }
}
