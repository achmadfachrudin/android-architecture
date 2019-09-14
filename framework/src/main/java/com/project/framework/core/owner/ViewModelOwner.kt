package com.project.framework.core.owner

import com.project.framework.core.BaseViewModel


interface ViewModelOwner<T : BaseViewModel> {
    val viewModel: T
}