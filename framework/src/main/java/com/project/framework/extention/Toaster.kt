@file:JvmName("Toaster")

package com.project.framework.extention

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

/**
 * Toaster
 * Extension to display the Toast message directly from Context, Activity, and Fragment
 */

fun Fragment.showToast(@StringRes stringResource: Int) = context?.showToast(stringResource)

fun Fragment.showToast(message: String) = context?.showToast(message)

fun Context.showToast(@StringRes stringResource: Int) = showToast(getString(stringResource))

fun Context.showToast(message: String) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

fun Fragment.showLongToast(@StringRes stringResource: Int) = context?.showLongToast(stringResource)

fun Fragment.showLongToast(message: String) = context?.showLongToast(message)

fun Context.showLongToast(@StringRes stringResource: Int) = showLongToast(getString(stringResource))

fun Context.showLongToast(message: String) = Toast.makeText(this, message, Toast.LENGTH_LONG).show()