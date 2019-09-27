object Apps {
    const val compileSdk = 29
    const val minSdk = 21
    const val targetSdk = 29
    const val versionCode = 1
    const val versionName = "1.0.0"
}

object Versions {
    const val gradle = "3.5.0"

    const val kotlin = "1.3.50"
    const val ktx = "1.1.0"
    const val coroutine = "1.3.1"
    const val ktlint = "0.34.2"
    const val ktlintPlugin = "8.2.0"

    const val appcompat = "1.1.0"
    const val support = "1.0.0"
    const val material = "1.0.0"
    const val constraint = "1.1.3"
    const val multidex = "2.0.1"
    const val databinding = "3.1.4"

    const val room = "2.1.0"
    const val koin = "2.0.1"
    const val eventbus = "3.1.1"

    const val retrofit = "2.6.1"
    const val retrofitCoroutine = "0.9.2"
    const val okhttp = "4.2.0"
    const val gander = "3.1.0"

    const val lottie = "3.0.7"
    const val glide = "4.9.0"

    /* test */
    const val junit = "4.12"
    const val mockito = "3.0.0"
    const val espresso = "3.2.0"
    const val testCore = "1.2.0"
    const val testJunit = "1.1.1"
}

object Libs {
    /* kotlin */
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val kotlinKtx = "androidx.core:core-ktx:${Versions.ktx}"
    const val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine}"
    const val coroutineAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine}"

    /* design */
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val support = "androidx.legacy:legacy-support-v4:${Versions.support}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraint = "androidx.constraintlayout:constraintlayout:${Versions.constraint}"
    const val multidex = "androidx.multidex:multidex:${Versions.multidex}"
    const val databinding = "com.android.databinding:compiler:${Versions.databinding}"

    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"

    const val koinViewModel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"
    const val eventbus = "org.greenrobot:eventbus:${Versions.eventbus}"

    /* network */
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitMoshi = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    const val retrofitCoroutine = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.retrofitCoroutine}"
    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    const val okhttpInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
    const val gander = "com.ashokvarma.android:gander-imdb:${Versions.gander}"
    const val ganderNoOp = "com.ashokvarma.android:gander-no-op:${Versions.gander}"

    /* image and animation */
    const val lottie = "com.airbnb.android:lottie:${Versions.lottie}"
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
}

object TestLibs {
    const val junit = "junit:junit:${Versions.junit}"
    const val coroutineTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutine}"
    const val koinTest = "org.koin:koin-test:${Versions.koin}"
    const val mockito = "org.mockito:mockito-core:${Versions.mockito}"
    const val mockitoInline = "org.mockito:mockito-inline:${Versions.mockito}"
    const val mockWebServer = "com.squareup.okhttp3:mockwebserver:${Versions.okhttp}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val testJunit = "androidx.test.ext:junit:${Versions.testJunit}"
    const val testCore = "androidx.test:core:${Versions.testCore}"
    const val testRunner = "androidx.test:runner:${Versions.testCore}"
    const val testRules = "androidx.test:rules:${Versions.testCore}"
}