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
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Hello"
include(":app")
include(":app:layout")
include(":event")
include(":explictintent")
include(":optionmenu")
include(":contextmenu")
include(":popupmenu")
include(":datetimepicker")
include(":notification")
include(":graphicshape")
include(":touchevent")
include(":singletouch")
include(":pingpong")
include(":musicservice")
