package com.project.data

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by achmad.fachrudin on 21-Mar-19
 */
object PrefManager {
    private const val NAME = "ProjectPreference"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var preferences: SharedPreferences

    private val IS_FIRST_OPEN = Pair("IS_FIRST_OPEN", true)
    private val IS_LIKE_MATH = Pair("IS_LIKE_MATH", true)

    fun init(context: Context) {
        preferences = context.getSharedPreferences(NAME, MODE)
    }

    /**
     * SharedPreferences extension function, so we won't need to call edit()
     * and apply() ourselves on every SharedPreferences operation.
     */
    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var isFirstOpen: Boolean
        get() = preferences.getBoolean(IS_FIRST_OPEN.first, IS_FIRST_OPEN.second)
        set(value) = preferences.edit {
            it.putBoolean(IS_FIRST_OPEN.first, value)
        }

    var isLikeMath: Boolean
        get() = preferences.getBoolean(IS_LIKE_MATH.first, IS_LIKE_MATH.second)
        set(value) = preferences.edit {
            it.putBoolean(IS_LIKE_MATH.first, value)
        }
}