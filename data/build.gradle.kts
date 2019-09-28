plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
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
        getByName("debug") {
            buildConfigField("String", "API_SAMPLE", "\"https://jsonplaceholder.typicode.com\"")
            buildConfigField("String", "API_BASE", "\"http://www.mocky.io/v2/\"")
        }
        getByName("release") {
            buildConfigField("String", "API_SAMPLE", "\"https://jsonplaceholder.typicode.com\"")
            buildConfigField("String", "API_BASE", "\"http://www.mocky.io/v2/\"")
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(":framework"))

    /* android test */
    testImplementation(TestLibs.junit)
    androidTestImplementation(TestLibs.testRules)
    androidTestImplementation(TestLibs.testJunit)
    androidTestImplementation(TestLibs.espresso)
}
