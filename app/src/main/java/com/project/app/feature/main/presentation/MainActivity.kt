package com.project.app.feature.main.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.project.app.R
import com.project.app.databinding.ActivityMainBinding
import com.project.app.feature.main.adapter.MenuListItemAdapter
import com.project.framework.core.BaseActivity
import com.project.framework.core.NetworkState
import com.project.framework.core.owner.ViewDataBindingOwner
import com.project.framework.core.owner.ViewModelOwner
import com.project.framework.widget.LoadingView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by achmad.fachrudin on 3-Jun-19
 */
class MainActivity : BaseActivity(),
    MainView,
    ViewModelOwner<MainViewModel>,
    ViewDataBindingOwner<ActivityMainBinding> {

    companion object {
        fun startThisActivity(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            context.startActivity(intent)
        }
    }

    override fun getViewLayoutResId(): Int {
        return R.layout.activity_main
    }

    override lateinit var binding: ActivityMainBinding
    override val viewModel: MainViewModel by viewModel()

    override var retryListener: LoadingView.OnRetryListener = object : LoadingView.OnRetryListener {
        override fun onRetry() {
            viewModel.getMenuFromApi()
        }
    }

    private var doubleBackPressed = false
    private lateinit var listAdapter: MenuListItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initUI()

        viewModel.getMenuFromApi()
        observeNetworkState()
        observeMenu()
    }

    private fun initUI() {
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(false)
            it.setHomeButtonEnabled(false)
        }

        title = getString(R.string.msg_main_title)

        listAdapter = MenuListItemAdapter()
        binding.rvList.adapter = listAdapter
    }

    private fun observeNetworkState() {
        observeData(viewModel.getNetworkState()) { networkState ->
            networkState?.let {
                when (it) {
                    NetworkState.LOADING -> {
                        viewModel.showLoadingView.set(true)
                    }
                    NetworkState.LOADED -> {
                        viewModel.showLoadingView.set(false)
                    }
                    NetworkState.EMPTY -> {
                        viewModel.showLoadingView.set(true)
                        binding.loadingView.showEmpty(
                            getString(R.string.msg_empty_title),
                            getString(R.string.msg_empty),
                            R.drawable.img_alert,
                            false,
                            null
                        )
                    }
                    else -> it.exception?.let { e ->
                        viewModel.showLoadingView.set(true)
                        binding.loadingView.showError(
                            e,
                            getString(R.string.msg_error_title),
                            getString(R.string.msg_error)
                        )
                    }
                }
            }
        }
    }

    private fun observeMenu() {
        observeData(viewModel.menu) { result ->
            result?.menu?.let {
                listAdapter.setData(it)
            }
        }
    }

    override fun onBackPressed() {
        if (doubleBackPressed) {
            super.onBackPressed()
            return
        }
        this.doubleBackPressed = true
        Toast.makeText(this, getString(R.string.msg_press_back_to_exit), Toast.LENGTH_SHORT).show()

        GlobalScope.launch(Dispatchers.Main) {
            delay(2000)
            doubleBackPressed = false
        }
    }
}