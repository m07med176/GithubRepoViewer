pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()

        maven(url = "https://jitpack.io")
        maven(url = "https://maven.google.com")
        maven(url = "https://developer.huawei.com/repo/")
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()

        maven(url = "https://jitpack.io")
        maven(url = "https://maven.google.com")
        maven(url = "https://developer.huawei.com/repo/")
    }
}

rootProject.name = "GithupRepoViewer"
include(":app")






