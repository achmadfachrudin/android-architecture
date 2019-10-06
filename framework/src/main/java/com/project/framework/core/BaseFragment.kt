package com.project.framework.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.project.framework.BR
import com.project.framework.core.owner.ViewDataBindingOwner

abstract class BaseFragment<VM : BaseViewModel> : Fragment() {

    abstract val layoutResourceId: Int
    abstract val viewModel: VM

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return getLayoutIfDefined(inflater, container)
    }

    private fun getLayoutIfDefined(inflater: LayoutInflater, container: ViewGroup?): View? {

        if (this is ViewDataBindingOwner<*>) {
            val view = inflateContentViewBinding(inflater, container, layoutResourceId)
            binding.setVariable(BR.vm, viewModel)
            if (this is BaseView) {
                binding.setVariable(BR.view, this)
            }
            return view
        } else {
            return inflater.inflate(layoutResourceId, container, false)
        }
    }
}