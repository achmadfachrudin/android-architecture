package com.project.app.module

import com.project.app.feature.addition.module.additionModule
import com.project.app.feature.fibonacci.module.fibonacciModule
import com.project.app.feature.main.module.mainModule
import com.project.app.feature.multiplication.module.multiplicationModule
import com.project.app.feature.primary.module.primaryModule
import com.project.feature_alpha.module.alphaModule
import com.project.feature_bravo.module.bravoModule

/**
 * Created by achmad.fachrudin on 13-Jun-19
 */
val featureModule = listOf(
    mainModule,
    additionModule,
    multiplicationModule,
    primaryModule,
    fibonacciModule,

    alphaModule,
    bravoModule
)
