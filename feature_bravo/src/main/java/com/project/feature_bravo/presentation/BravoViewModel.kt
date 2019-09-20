package com.project.feature_bravo.presentation

import androidx.databinding.ObservableField
import com.project.framework.core.BaseViewModel

/**
 * Created by achmad.fachrudin on 18-Jun-19
 */
class BravoViewModel : BaseViewModel() {
    var textPref = ObservableField<String>()
    var textTest = ObservableField<String>()
}