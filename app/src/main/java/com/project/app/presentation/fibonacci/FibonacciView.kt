package com.project.app.presentation.fibonacci

import android.text.TextWatcher
import android.view.View
import com.project.framework.core.BaseView


interface FibonacciView : BaseView {
    var textWatcherA: TextWatcher
    fun onClickCalculate(view: View)
}