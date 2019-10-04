package com.project.feature_yankee.module

import com.project.feature_yankee.presentation.YankeeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by achmad.fachrudin on 18-Jun-19
 */
val yankeeModule = module {

    viewModel { YankeeViewModel() }
}