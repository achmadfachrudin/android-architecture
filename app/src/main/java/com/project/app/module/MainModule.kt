package com.project.app.module

import com.project.app.presentation.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by achmad.fachrudin on 3-Jun-19
 */
val mainModule = module {

    viewModel { MainViewModel(get()) }
}

