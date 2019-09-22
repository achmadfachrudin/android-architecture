plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(Apps.compileSdk)

    defaultConfig {
        minSdkVersion(Apps.minSdk)
        targetSdkVersion(Apps.targetSdk)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    dataBinding {
        isEnabled = true
    }

    lintOptions {
        isAbortOnError = false
        isIgnoreWarnings = true
        isQuiet = true
    }

    packagingOptions {
        exclude("META-INF/DEPENDENCIES")
        exclude("META-INF/DEPENDENCIES.txt")
        exclude("META-INF/dependencies")
        exclude("META-INF/dependencies.txt")
        exclude("META-INF/LICENSE")
        exclude("META-INF/LICENSE.txt")
        exclude("META-INF/license")
        exclude("META-INF/license.txt")
        exclude("META-INF/NOTICE")
        exclude("META-INF/NOTICE.txt")
        exclude("META-INF/notice")
        exclude("META-INF/notice.txt")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled  = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    sourceSets {
        getByName("main").java.srcDirs(file("src/main/kotlin"), file("src/main/kapt"))
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    /* kotlin */
    api(Libs.kotlin)
    api(Libs.kotlinKtx)
    api(Libs.coroutine)
    api(Libs.coroutineAndroid)

    /* android */
    api(Libs.appcompat)
    api(Libs.support)
    api(Libs.material)
    api(Libs.constraint)
    api(Libs.multidex)
    kapt(Libs.databinding)
    api("com.google.android.play:core:1.6.3")

    /* room */
    api(Libs.roomRuntime)
    api(Libs.roomKtx)
    kapt(Libs.roomCompiler)

    /* di and viewModel */
    api(Libs.koinViewModel)

    /* eventBus */
    api(Libs.eventbus)

    /* network */
    api(Libs.retrofit)
    api(Libs.retrofitMoshi)
    api(Libs.retrofitCoroutine)
    api(Libs.okhttp)
    api(Libs.okhttpInterceptor)
    debugApi(Libs.gander)
    releaseApi(Libs.ganderNoOp)

    /* image and animation */
    api(Libs.lottie)
    api(Libs.glide)
    kapt(Libs.glideCompiler)

    /* android test */
    testImplementation(TestLibs.junit)
    androidTestImplementation(TestLibs.testRules)
    androidTestImplementation(TestLibs.testJunit)
    androidTestImplementation(TestLibs.espresso)
}
