package com.project.app.feature.multiplication

import androidx.databinding.ObservableField
import com.project.framework.core.BaseViewModel


/**
 * Created by achmad.fachrudin on 7-Jun-19
 */
class MultiplicationViewModel : BaseViewModel() {
    var bTextA = ObservableField<String>()
    var bTextB = ObservableField<String>()
    var bTextResult = ObservableField<String>()
    var isShowButton = ObservableField(false)

    var valueA = 0
    var valueB = 0
}