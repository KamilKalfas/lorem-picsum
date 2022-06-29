buildscript {

    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }

    dependencies {
        classpath(GradleConfig.Android_Gradle)
        classpath(GradleConfig.Kotlin)
        classpath(GradleConfig.Detekt)
        classpath(GradleConfig.NavSafeArgs)
    }
}

apply(from = "gradle/detekt.gradle.kts")

subprojects {
    repositories {
        google()
        mavenCentral()
    }
}

task("clean", type = Delete::class) {
    delete(rootProject.buildDir)
}
