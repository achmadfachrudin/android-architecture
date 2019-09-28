package com.project.feature_bravo.module

import com.project.feature_bravo.presentation.BravoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by achmad.fachrudin on 18-Jun-19
 */
val bravoModule = module {

    viewModel { BravoViewModel() }
}