pluginManagement {
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id == "net.minecraftforge.gradle") {
                useModule("${requested.id}:ForgeGradle:${requested.version}")
            }
        }
    }

    repositories {
        gradlePluginPortal()
        maven {
            url = uri("https://maven.minecraftforge.net/")
        }
        maven {
            name = "FancyGradle"
            url = uri("https://maven.gofancy.wtf/releases")
        }
    }
}

rootProject.name = "Planar Artifice"
