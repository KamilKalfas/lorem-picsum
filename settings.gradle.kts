include(":app")
rootProject.name = "Lorem Picsum"

rootProject.children.forEach { project ->
    project.buildFileName = "${project.name}_build.gradle.kts"
}
