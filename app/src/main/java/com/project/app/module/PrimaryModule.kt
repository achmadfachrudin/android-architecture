package com.project.app.module

import com.project.app.presentation.primary.PrimaryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by achmad.fachrudin on 9-Jun-19
 */
val primaryModule = module {

    viewModel { PrimaryViewModel() }
}

