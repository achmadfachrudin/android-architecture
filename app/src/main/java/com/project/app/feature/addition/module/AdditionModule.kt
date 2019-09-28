package com.project.app.feature.addition.module

import com.project.app.feature.addition.presentation.AdditionViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by achmad.fachrudin on 3-Jun-19
 */
val additionModule = module {

    viewModel { AdditionViewModel() }
}