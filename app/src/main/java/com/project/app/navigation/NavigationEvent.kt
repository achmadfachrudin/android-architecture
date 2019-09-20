package com.project.app.navigation

import android.content.Context
import android.os.Bundle

/**
 * Created by achmad.fachrudin on 17-Jun-19
 */
data class NavigationEvent(val context: Context, val page: Navigation) {
    var bundle: Bundle? = null
}