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
include(":core")
include(":coreUi")
include(":feature:feed")
include(":feature:profile")
include(":feature:settings")
include(":feature:feed:data")
include(":feature:feed:domain")
include(":feature:profile:data")
include(":feature:profile:domain")
include(":feature:settings:data")
include(":feature:settings:domain")
