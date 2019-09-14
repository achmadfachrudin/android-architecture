package com.project.app.feature.main.adapter

import androidx.databinding.ObservableField
import com.project.framework.core.BaseViewModel

/**
 * Created by achmad.fachrudin on 3-Jun-19
 */
class MenuListItemViewModel : BaseViewModel() {
    var bTextTitle = ObservableField<String>()
    var bShowImage = ObservableField(false)
}