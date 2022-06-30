buildscript {
    repositories {
        google()
        maven(url = "https://plugins.gradle.org/m2/")
        mavenCentral()
        gradlePluginPortal()
    }

    dependencies {
        classpath(GradleConfig.AndroidGP)
        classpath(GradleConfig.KotlinGP)
        classpath(GradleConfig.SafeArgsGP)
    }
}

subprojects {
    repositories {
        google()
        mavenCentral()
    }
}

task("clean", type = Delete::class) {
    delete(rootProject.buildDir)
}
