package com.project.app.feature.main.module

import com.project.app.feature.main.presentation.MainViewModel
import com.project.app.feature.main.presentation.SplashScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by achmad.fachrudin on 3-Jun-19
 */
val mainModule = module {

    viewModel { SplashScreenViewModel() }

    viewModel { MainViewModel(get()) }
}