package com.project.app.feature.main.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.google.android.play.core.splitinstall.SplitInstallManager
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import com.google.android.play.core.splitinstall.SplitInstallRequest
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener
import com.google.android.play.core.splitinstall.model.SplitInstallSessionStatus
import com.project.app.R
import com.project.app.databinding.ActivityMainBinding
import com.project.app.feature.main.adapter.MenuListItemAdapter
import com.project.framework.core.BaseActivity
import com.project.framework.core.NetworkState
import com.project.framework.core.owner.ViewDataBindingOwner
import com.project.framework.core.owner.ViewModelOwner
import com.project.framework.extention.showLongToast
import com.project.framework.extention.showToast
import com.project.framework.widget.LoadingView
import kotlinx.android.synthetic.main.activity_main.*
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

    // for dynamic feature
    private lateinit var manager: SplitInstallManager
    private val listener = SplitInstallStateUpdatedListener { state ->
        state.moduleNames().forEach { name ->
            when (state.status()) {
                SplitInstallSessionStatus.DOWNLOADING -> {
                    progress_bar.max = state.totalBytesToDownload().toInt()
                    progress_bar.progress = state.bytesDownloaded().toInt()
                    showLongToast("Downloading $name")
                }
                SplitInstallSessionStatus.INSTALLING -> {
                    progress_bar.max = state!!.totalBytesToDownload().toInt()
                    progress_bar.progress = state.bytesDownloaded().toInt()
                    showLongToast("Installing $name")
                }
                SplitInstallSessionStatus.INSTALLED -> {
                    progress_bar.max = 100
                    progress_bar.progress = 50
                    progress_bar.visibility = View.GONE
                    showLongToast("$name Successfully installed")
                }
                SplitInstallSessionStatus.FAILED -> {
                    progress_bar.visibility = View.GONE
                    showLongToast("$name Failed installed")
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initUI()
        initDynamicFeature()

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

    private fun initDynamicFeature() {
        manager = SplitInstallManagerFactory.create(this)

        btn_feature.setOnClickListener {
            if (manager.installedModules.contains("feature_yankee")) {
                Intent().setClassName(
                    packageName,
                    "com.project.feature_yankee.presentation.YankeeActivity"
                ).also { startActivity(it) }
            } else {
                val request = SplitInstallRequest.newBuilder()
                    .addModule("feature_yankee")
                    .build()
                manager.startInstall(request).addOnSuccessListener {
                    progress_bar.isIndeterminate = false
                }
            }
        }
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

    override fun onResume() {
        manager.registerListener(listener)
        super.onResume()
    }

    override fun onPause() {
        manager.unregisterListener(listener)
        super.onPause()
    }

    override fun onBackPressed() {
        if (doubleBackPressed) {
            super.onBackPressed()
            return
        }

        doubleBackPressed = true
        showToast(getString(R.string.msg_press_back_to_exit))

        launch {
            delay(2000)
            doubleBackPressed = false
        }
    }
}