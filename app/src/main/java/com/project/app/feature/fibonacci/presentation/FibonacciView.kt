package com.project.app.feature.fibonacci.presentation

import android.text.TextWatcher
import android.view.View
import com.project.framework.core.BaseView

/**
 * Created by achmad.fachrudin on 11-Jun-19
 */
interface FibonacciView : BaseView {
    var textWatcherA: TextWatcher
    fun onClickCalculate(view: View)
}