// Created by Usmon Abdurakhmanv on 7/31/2022.

object ProjectConfig {
    const val appId = "io.usmon.pdpmobile"
    const val compileSdk = 32
    const val minSdk = 25
    const val targetSdk = 32
    const val versionCode = 1
    const val versionName = "1.0"

    const val testRunnerPackage = "androidx.test.runner.AndroidJUnitRunner"

    const val consumerProguardFiles = "consumer-rules.pro"
    const val proguardAndroidOptimize = "proguard-android-optimize.txt"

    const val jvmTarget = "1.8"

    const val isMinifyEnabled: Boolean = false
    const val isShrinkResourcesEnabled: Boolean = false
}