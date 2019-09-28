package com.project.app.feature.primary.module

import com.project.app.feature.primary.presentation.PrimaryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by achmad.fachrudin on 9-Jun-19
 */
val primaryModule = module {

    viewModel { PrimaryViewModel() }
}