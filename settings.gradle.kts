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
include(":core:common")
include(":core:data-test")
include(":lint")

include(":core:datastore-test")
include(":features:insert_transaction")
include(":features:setup")
