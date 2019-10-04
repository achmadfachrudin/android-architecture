package com.project.framework.core

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import com.project.framework.BR
import com.project.framework.core.owner.ViewDataBindingOwner
import com.project.framework.core.owner.ViewModelOwner
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

abstract class BaseActivity : AppCompatActivity(), CoroutineScope {

    private val parentJob = SupervisorJob()
    override val coroutineContext: CoroutineContext = parentJob + Dispatchers.Main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setLayoutIfDefined()
    }

    private fun setLayoutIfDefined() {
        val layoutResId = getViewLayoutResId()
        if (layoutResId == View.NO_ID) return

        if (this is ViewDataBindingOwner<*>) {
            setContentViewBinding(this, layoutResId)
            if (this is ViewModelOwner<*>) {
                binding.setVariable(BR.vm, this.viewModel)
            }
            if (this is BaseView) {
                binding.setVariable(BR.view, this)
            }
        } else {
            setContentView(layoutResId)
        }
    }

    protected open fun getViewLayoutResId(): Int {
        val layout = javaClass.annotations.find { it is ViewLayout } as? ViewLayout
        return layout?.value ?: View.NO_ID
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        item?.itemId?.let {
            if (it == android.R.id.home)
                onToolBarBackButtonPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    protected open fun onToolBarBackButtonPressed() {
        finish()
    }

    protected fun setHomeAsUpIndicator(@DrawableRes resId: Int) {
        supportActionBar?.setHomeAsUpIndicator(resId)
    }
}