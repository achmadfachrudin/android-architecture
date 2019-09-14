package com.project.app.module

import com.project.app.presentation.fibonacci.FibonacciViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val fibonacciModule = module {

    viewModel { FibonacciViewModel() }
}

