package com.project.app.feature.primary.presentation

import androidx.databinding.ObservableField
import com.project.framework.core.BaseViewModel

/**
 * Created by achmad.fachrudin on 9-Jun-19
 */
class PrimaryViewModel : BaseViewModel() {
    var bTextA = ObservableField<String>()
    var bTextResult = ObservableField<String>()
    var isShowButton = ObservableField(false)
}