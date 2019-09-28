package com.project.app.feature.multiplication.presentation

import android.text.TextWatcher
import android.view.View
import com.project.framework.core.BaseView

/**
 * Created by achmad.fachrudin on 7-Jun-19
 */
interface MultiplicationView : BaseView {
    var textWatcherA: TextWatcher
    var textWatcherB: TextWatcher
    fun onClickCalculate(view: View)
}