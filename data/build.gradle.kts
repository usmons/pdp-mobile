plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdk = ProjectConfig.compileSdk

    defaultConfig {
        minSdk = ProjectConfig.minSdk
        targetSdk = ProjectConfig.targetSdk

        testInstrumentationRunner = ProjectConfig.testRunnerPackage
        consumerProguardFiles(ProjectConfig.consumerProguardFiles)
    }

    buildTypes {
        release {
            isMinifyEnabled = ProjectConfig.isMinifyEnabled
            isShrinkResources = ProjectConfig.isShrinkResourcesEnabled
            proguardFiles(getDefaultProguardFile(ProjectConfig.proguardAndroidOptimize), ProjectConfig.consumerProguardFiles)
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = ProjectConfig.jvmTarget
    }
}

dependencies {

    // Room for caching data
    implementation(Room.roomRuntime)
    kapt(Room.roomCompiler)
    // Kotlin Extensions and Coroutines support for Room
    implementation(Room.roomCoroutineSupport)

    // Coroutines
    implementation(Jetbrains.coroutinesCore)
    implementation(Jetbrains.coroutinesAndroid)

    // Modules
    implementation(project(Modules.domain))
}