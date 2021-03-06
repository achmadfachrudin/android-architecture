package com.project.feature_alpha.presentation

import androidx.databinding.ObservableField
import com.project.framework.core.BaseViewModel

/**
 * Created by achmad.fachrudin on 18-Jun-19
 */
class AlphaViewModel : BaseViewModel() {
    var textPref = ObservableField<String>()
    var stringData = ObservableField<String>("alpha-success")
}