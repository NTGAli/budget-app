pluginManagement {
    repositories {
        includeBuild("build-logic")
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "budget app"
include(":app")

include(":core:designsystem")

include(":core:analytics")
include(":core:data")
include(":core:database")
include(":features:home")
include(":core:model")
include(":core:datastore")
include(":core:datastore-proto")
include(":core:ui")
