package com.evolutionsoftware.auther.presentation.splash

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.evolutionsoftware.auther.domain.repository.MainRepository
import com.evolutionsoftware.auther.domain.useCases.GetUserDetails
import com.evolutionsoftware.auther.presentation.main.MainState
import kotlinx.coroutines.launch

class SplashViewModel(private val mainRepository: MainRepository) : ViewModel() {
    var state by mutableStateOf(MainState())
        private set

    init {
        fetchUserDetails()
    }

    private fun fetchUserDetails() {
        viewModelScope.launch {
            val user = GetUserDetails(mainRepository).invoke()
            state = state.copy(user = user)
        }
    }
}