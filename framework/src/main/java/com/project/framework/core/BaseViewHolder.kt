package com.project.framework.core

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.project.framework.BR
import com.project.framework.core.owner.ViewDataBindingOwner

abstract class BaseViewHolder<T>(val context: Context, view: View) : RecyclerView.ViewHolder(view) {

    init {
        if (this is ViewDataBindingOwner<*>) {
            setViewBinding(view)
            if (this is BaseViewItem) {
                binding.setVariable(BR.view, this)
            }
        }
    }

    abstract var data: T
    abstract fun bindData()
}
