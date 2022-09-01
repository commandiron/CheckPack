buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Build.androidBuildTools)
        classpath(Build.kotlinGradlePlugin)
        classpath(DaggerHilt.hiltAndroidGradlePlugin)
        classpath(Google.services)
        classpath(Firebase.crashlyticsPlugin)
    }
}

tasks.register("clean", Delete::class){
    delete(rootProject.buildDir)
}