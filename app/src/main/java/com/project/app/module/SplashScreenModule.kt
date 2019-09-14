package com.project.app.module

import com.project.app.presentation.splashscreen.SplashScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by achmad.fachrudin on 3-Jun-19
 */
val splashScreenModule = module {

    viewModel { SplashScreenViewModel() }
}

