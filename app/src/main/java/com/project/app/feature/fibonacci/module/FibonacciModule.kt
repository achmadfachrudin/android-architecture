package com.project.app.feature.fibonacci.module

import com.project.app.feature.fibonacci.presentation.FibonacciViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by achmad.fachrudin on 11-Jun-19
 */
val fibonacciModule = module {

    viewModel { FibonacciViewModel() }
}

