package com.project.feature_alpha.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.project.data.PrefManager
import com.project.feature_alpha.R
import com.project.feature_alpha.databinding.ActivityAlphaBinding
import com.project.framework.core.BaseActivity
import com.project.framework.core.owner.ViewDataBindingOwner
import com.project.framework.core.owner.ViewModelOwner
import com.project.framework.navigation.Navigation
import com.project.framework.navigation.NavigationEvent
import org.greenrobot.eventbus.EventBus
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by achmad.fachrudin on 18-Jun-19
 */
class AlphaActivity : BaseActivity(),
    AlphaView,
    ViewModelOwner<AlphaViewModel>,
    ViewDataBindingOwner<ActivityAlphaBinding> {

    companion object {
        fun startThisActivity(context: Context) {
            val intent = Intent(context, AlphaActivity::class.java)
            context.startActivity(intent)
        }
    }

    override val layoutResourceId = R.layout.activity_alpha
    override lateinit var binding: ActivityAlphaBinding
    override val viewModel: AlphaViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initUI()
    }

    private fun initUI() {
        title = getString(R.string.msg_alpha_title)

        viewModel.textPref.set("Preference: Do you like Math? ${PrefManager.isLikeMath}")
    }

    override fun onClickChangePref(view: View) {
        PrefManager.isLikeMath = !PrefManager.isLikeMath
        viewModel.textPref.set("Preference: Do you like Math? ${PrefManager.isLikeMath}")
    }

    override fun onClickGotoFeatureBravo(view: View) {
        val event = NavigationEvent(this, Navigation.FEATURE_B)
        val bundle = Bundle()
        bundle.putString("TEXT_TEST", viewModel.stringData.get())
        event.bundle = bundle
        EventBus.getDefault().post(event)
    }
}