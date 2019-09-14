package com.project.app.feature.addition.presentation

import android.text.TextWatcher
import android.view.View
import com.project.framework.core.BaseView

/**
 * Created by achmad.fachrudin on 3-Jun-19
 */
interface AdditionView : BaseView {
    var textWatcherA: TextWatcher
    var textWatcherB: TextWatcher
    fun onClickCalculate(view: View)
}