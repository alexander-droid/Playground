pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "Playground"
include(":app")
include(":utils")
include(":utilsUi")
include(":feature:feed")
include(":feature:feed:data")
include(":feature:feed:domain")
include(":feature:profile")
include(":feature:profile:data")
include(":feature:profile:domain")
include(":feature:settings")
include(":feature:settings:data")
include(":feature:settings:domain")
include(":feature:auth")
include(":feature:auth:data")
include(":feature:auth:domain")
include(":core:data")
include(":core:domain")
