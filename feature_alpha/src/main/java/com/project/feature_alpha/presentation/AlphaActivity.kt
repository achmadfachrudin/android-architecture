package com.project.feature_alpha.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.project.feature_alpha.R
import com.project.feature_alpha.databinding.ActivityAlphaBinding
import com.project.framework.core.BaseActivity
import com.project.framework.core.owner.ViewDataBindingOwner
import com.project.framework.core.owner.ViewModelOwner
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by achmad.fachrudin on 18-Jun-19
 */
class AlphaActivity : BaseActivity(),
    AlphaView,
    ViewModelOwner<AlphaViewModel>,
    ViewDataBindingOwner<ActivityAlphaBinding> {

    override fun getViewLayoutResId(): Int {
        return R.layout.activity_alpha
    }

    companion object {
        fun startThisActivity(context: Context) {
            val intent = Intent(context, AlphaActivity::class.java)
            context.startActivity(intent)
        }
    }

    override lateinit var binding: ActivityAlphaBinding
    override val viewModel: AlphaViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initUI()
    }

    private fun initUI() {
        title = getString(R.string.msg_alpha_title)
    }

    override fun onClickGotoFeatureBravo(view: View) {
        // ignore
    }
}