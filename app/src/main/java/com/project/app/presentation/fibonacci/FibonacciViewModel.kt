package com.project.app.presentation.fibonacci

import androidx.databinding.ObservableField
import com.project.framework.core.BaseViewModel


class FibonacciViewModel : BaseViewModel() {
    var bTextA = ObservableField<String>()
    var bTextResult = ObservableField<String>()
    var isShowButton = ObservableField(false)
}