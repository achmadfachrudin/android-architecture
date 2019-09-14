package com.project.app.presentation.main

import com.project.framework.core.BaseView
import com.project.framework.widget.LoadingView

/**
 * Created by achmad.fachrudin on 3-Jun-19
 */
interface MainView : BaseView {
    var retryListener: LoadingView.OnRetryListener
}