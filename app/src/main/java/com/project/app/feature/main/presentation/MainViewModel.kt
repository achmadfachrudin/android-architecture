package com.project.app.feature.main.presentation

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.project.data.entities.menu.Menu
import com.project.data.repository.MainRepository
import com.project.framework.core.BaseViewModel
import com.project.framework.core.NetworkState
import kotlinx.coroutines.launch

/**
 * Created by achmad.fachrudin on 3-Jun-19
 */
class MainViewModel(private val mainRepository: MainRepository) : BaseViewModel() {

    val showLoadingView = ObservableField(true)
    var menu: MutableLiveData<Menu> = MutableLiveData()

    fun getMenuFromApi() {
        networkState.value = NetworkState.LOADING

        launch {
            val request = mainRepository.getMenuAsync()
            try {
                val response = request.await()

                menu.value = response.body()

                if (response.body()?.menu!!.isEmpty()) {
                    networkState.value = NetworkState.EMPTY
                } else {
                    networkState.value = NetworkState.LOADED
                }
            } catch (e: Exception) {
                networkState.value = NetworkState.error(e)
            }
        }
    }
}