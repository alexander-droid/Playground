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
include(":core:data")
include(":core:domain")
include(":feature:feed")
include(":feature:feed:data")
include(":feature:feed:domain")
include(":feature:profile")
include(":feature:profile:data")
include(":feature:profile:domain")
include(":feature:chat")
include(":feature:chat:data")
include(":feature:chat:domain")
include(":feature:auth")
include(":feature:auth:data")
include(":feature:auth:domain")
include(":feature:questionnaire")
include(":feature:questionnaire:data")
include(":feature:questionnaire:domain")
