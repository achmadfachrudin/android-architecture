package com.project.framework.core

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {
    var initialState: MutableLiveData<NetworkState> = MutableLiveData()
    var networkState: MutableLiveData<NetworkState> = MutableLiveData()

    fun getInitialState(): LiveData<NetworkState> {
        return initialState
    }

    fun getNetworkState(): LiveData<NetworkState> {
        return networkState
    }
}