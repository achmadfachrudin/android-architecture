package com.project.feature_bravo.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.project.data.PrefManager
import com.project.feature_bravo.R
import com.project.feature_bravo.databinding.ActivityBravoBinding
import com.project.framework.core.BaseActivity
import com.project.framework.core.owner.ViewDataBindingOwner
import com.project.framework.navigation.Navigation
import com.project.framework.navigation.NavigationEvent
import org.greenrobot.eventbus.EventBus
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by achmad.fachrudin on 18-Jun-19
 */
class BravoActivity : BaseActivity<BravoViewModel>(),
    BravoView,
    ViewDataBindingOwner<ActivityBravoBinding> {

    companion object {
        const val TEXT_TEST = "TEXT_TEST"

        fun startThisActivity(context: Context, textTest: String?) {
            val intent = Intent(context, BravoActivity::class.java)
            intent.putExtra(TEXT_TEST, textTest)
            context.startActivity(intent)
        }
    }

    override val layoutResourceId = R.layout.activity_bravo
    override lateinit var binding: ActivityBravoBinding
    override val viewModel: BravoViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initUI()
    }

    private fun initUI() {
        title = getString(R.string.msg_bravo_title)

        // get data from bundle
        intent.extras?.let { bundle ->
            bundle.getString(TEXT_TEST)?.let {
                viewModel.textTest.set("Data from Alpha: $it")
            }
        }

        // get data from preference
        viewModel.textPref.set("Preference: Do you like Math? ${PrefManager.isLikeMath}")
    }

    override fun onClickGotoHome(view: View) {
        val event = NavigationEvent(this, Navigation.MAIN_PAGE)
        EventBus.getDefault().post(event)
    }
}