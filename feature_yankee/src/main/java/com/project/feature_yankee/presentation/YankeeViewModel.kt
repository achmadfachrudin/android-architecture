package com.project.feature_yankee.presentation

import androidx.databinding.ObservableField
import com.project.framework.core.BaseViewModel

/**
 * Created by achmad.fachrudin on 18-Jun-19
 */
class YankeeViewModel : BaseViewModel() {
    var textPref = ObservableField<String>()
    var stringData = ObservableField<String>("alpha-success")
}