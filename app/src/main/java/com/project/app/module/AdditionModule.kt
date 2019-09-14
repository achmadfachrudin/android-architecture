package com.project.app.module

import com.project.app.presentation.addition.AdditionViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by achmad.fachrudin on 3-Jun-19
 */
val additionModule = module {

    viewModel { AdditionViewModel() }
}

