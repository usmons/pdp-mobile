plugins {
    id("com.android.application")
    id("dagger.hilt.android.plugin")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdk = ProjectConfig.compileSdk

    defaultConfig {
        applicationId = ProjectConfig.appId
        minSdk = ProjectConfig.minSdk
        targetSdk = ProjectConfig.targetSdk
        versionCode = ProjectConfig.versionCode
        versionName = ProjectConfig.versionName

        testInstrumentationRunner = ProjectConfig.testRunnerPackage
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = ProjectConfig.isMinifyEnabled
            isShrinkResources = ProjectConfig.isShrinkResourcesEnabled
            proguardFiles(getDefaultProguardFile(ProjectConfig.proguardAndroidOptimize), ProjectConfig.consumerProguardFiles)
        }
    }
    buildFeatures {
        viewBinding = true
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

    // AndroidX
    implementation(AndroidX.core)
    implementation(AndroidX.appCompat)
    implementation(AndroidX.constraintLayout)
    implementation(AndroidX.recyclerView)
    implementation(AndroidX.legacySupport)
    implementation(AndroidX.lifecycleViewModel)
    implementation(AndroidX.lifecycleLiveData)
    implementation(AndroidX.lifecycleRuntime)
    implementation(AndroidX.fragment)

    // Room for caching data
    implementation(Room.roomRuntime)
    kapt(Room.roomCompiler)
    // Kotlin Extensions and Coroutines support for Room
    implementation(Room.roomCoroutineSupport)

    // Jetpack Navigation
    implementation(AndroidX.navigationFragment)
    implementation(AndroidX.navigationUI)

    // Google material design
    implementation(Google.material)

    // Dagger Hilt for dependency injection
    implementation(DaggerHilt.hiltAndroid)
    implementation(DaggerHilt.hiltViewModel)
    kapt(DaggerHilt.hiltAndroidCompiler)
    kapt(DaggerHilt.hiltCompiler)

    // Coroutines
    implementation(Jetbrains.coroutinesCore)
    implementation(Jetbrains.coroutinesAndroid)

    // Modules
    implementation(project(Modules.data))
    implementation(project(Modules.domain))

    // Tests
    testImplementation(Test.jUnit)
    androidTestImplementation(Test.jUnitExt)
    androidTestImplementation(Test.espresso)


}