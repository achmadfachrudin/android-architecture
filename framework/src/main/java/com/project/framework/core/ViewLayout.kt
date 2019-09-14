package com.project.framework.core

import androidx.annotation.LayoutRes
import androidx.annotation.NonNull
import android.view.View


@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class ViewLayout(@LayoutRes @NonNull val value: Int = View.NO_ID)