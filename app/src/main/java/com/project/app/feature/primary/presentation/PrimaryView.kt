package com.project.app.feature.primary.presentation

import android.text.TextWatcher
import android.view.View
import com.project.framework.core.BaseView

/**
 * Created by achmad.fachrudin on 9-Jun-19
 */
interface PrimaryView : BaseView {
    var textWatcherA: TextWatcher
    fun onClickCalculate(view: View)
}