package com.project.framework.core

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

interface BaseView : LifecycleOwner {

    fun <T> observeData(data: LiveData<T>, observer: Observer<T>) {
        data.observe(this, observer)
    }

    fun <T> observeData(data: LiveData<T>, onChanged: (T?) -> Unit) {
        observeData(data, Observer { onChanged(it) })
    }
}