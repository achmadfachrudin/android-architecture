import java.util.Properties
import java.io.FileInputStream

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(Apps.compileSdk)
    defaultConfig {
        minSdkVersion(Apps.minSdk)
        targetSdkVersion(Apps.targetSdk)
        versionCode = Apps.versionCode
        versionName = Apps.versionName
        multiDexEnabled = true
        setProperty("archivesBaseName", "$applicationId-v$versionName($versionCode)")
        resConfigs("en")
        ndk {
            abiFilters("armeabi-v7a", "x86", "arm64-v8a", "x86_64")
        }
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    dataBinding {
        isEnabled = true
    }

    bundle {
        language { enableSplit = true }
        density { enableSplit = true }
        abi { enableSplit = true }
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

    signingConfigs {
        if (rootProject.file("signing-debug.properties").exists()) {
            val signingDebug = Properties()
            signingDebug.load(FileInputStream(rootProject.file("signing-debug.properties")))
            getByName("debug") {
                storeFile = rootProject.file(signingDebug.getProperty("storeFile"))
                storePassword = signingDebug.getProperty("storePassword")
                keyAlias = signingDebug.getProperty("keyAlias")
                keyPassword = signingDebug.getProperty("keyPassword")
            }
        }
        if (rootProject.file("signing-release.properties").exists()) {
            val signingRelease = Properties()
            signingRelease.load(FileInputStream(rootProject.file("signing-release.properties")))
            create("release") {
                storeFile = rootProject.file(signingRelease.getProperty("storeFile"))
                storePassword = signingRelease.getProperty("storePassword")
                keyAlias = signingRelease.getProperty("keyAlias")
                keyPassword = signingRelease.getProperty("keyPassword")
            }
        }
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            isDebuggable = true
            applicationIdSuffix = ".debug"
            versionNameSuffix = "-dev"
            signingConfig = signingConfigs.getByName("debug")
        }
        getByName("release") {
            isMinifyEnabled = true
            isDebuggable = false
            isShrinkResources = true
            isZipAlignEnabled = true
            isJniDebuggable = false
            isRenderscriptDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("release")
        }
    }

    testOptions {
        unitTests.isReturnDefaultValues = true
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    /* project */
    implementation(project(":framework"))
    implementation(project(":data"))

    /* android test */
    testImplementation(TestLibs.junit)
    testImplementation(TestLibs.coroutineTest)
    testImplementation(TestLibs.koinTest)
    testImplementation(TestLibs.mockito)
    testImplementation(TestLibs.mockitoInline)
    androidTestImplementation(TestLibs.testCore)
    androidTestImplementation(TestLibs.testRunner)
    androidTestImplementation(TestLibs.testRules)
    androidTestImplementation(TestLibs.testJunit)
    androidTestImplementation(TestLibs.espresso)
}
