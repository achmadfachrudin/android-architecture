package com.project.feature_alpha.module

import com.project.feature_alpha.presentation.AlphaViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by achmad.fachrudin on 18-Jun-19
 */
val alphaModule = module {

    viewModel { AlphaViewModel() }
}

