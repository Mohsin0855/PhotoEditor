pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Photo Editor"
include(":app")
include("features:home")
include("features:editor")
include("features:transformation")
include("features:filters")
include("features:adjust")
include("features:blur")
include("features:background-remover")
include("features:ratios")
include("features:draw")
include("features:text-overlay")
include("features:stickers")
include("features:glitch")
include("features:collage")
include("core:common")
include("core:ui")
include("core:db")
