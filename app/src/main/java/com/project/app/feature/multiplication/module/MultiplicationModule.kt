package com.project.app.feature.multiplication.module

import com.project.app.feature.multiplication.presentation.MultiplicationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by achmad.fachrudin on 7-Jun-19
 */
val multiplicationModule = module {

    viewModel { MultiplicationViewModel() }
}

