buildscript {

    repositories {
        google()
        // Other repositories
    }

    dependencies {
        classpath("com.google.gms:google-services:4.4.0")
        classpath ("com.android.tools.build:gradle:4.1.3")

    }
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.0" apply false
}