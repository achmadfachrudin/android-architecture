package com.project.app.navigation

import android.content.Intent
import com.project.app.feature.main.presentation.MainActivity
import com.project.feature_alpha.presentation.AlphaActivity

/**
 * Created by achmad.fachrudin on 17-Jun-19
 */
object NavigationRoute {
    fun executeEvent(event: NavigationEvent) {
        when (event.page) {
            Navigation.MAIN_PAGE -> {
                val intent = Intent(event.context, MainActivity::class.java)
                event.bundle?.let {
                    intent.putExtras(it)
                }
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                event.context.startActivity(intent)
            }
            Navigation.FEATURE_A -> {
                AlphaActivity.startThisActivity(event.context)
            }
            Navigation.FEATURE_B -> {
//                BravoActivity.startThisActivity(event.context)
            }
            Navigation.FEATURE_C -> {
//                event.bundle?.let {
//                    CharlieActivity.startThisActivity(
//                        event.context,
//                        it.getString("TEXT_TEST")
//                    )
//                }
            }
        }
    }
}