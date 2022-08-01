// Created by Usmon Abdurakhmanv on 7/31/2022.

object Build {

    private const val androidBuildToolsVersion = "7.2.1"
    const val androidBuildTools = "com.android.tools.build:gradle:$androidBuildToolsVersion"

    private const val kotlinVersion = "1.7.10"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"

    private const val hiltVersion = "2.42"
    const val hiltAndroidPlugin = "com.google.dagger:hilt-android-gradle-plugin:$hiltVersion"
}