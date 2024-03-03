package com.evolutionsoftware.auther.presentation.credentials

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.evolutionsoftware.auther.domain.repository.MainRepository
import com.evolutionsoftware.auther.domain.useCases.SetUserCredentials
import kotlinx.coroutines.launch

class CredentialsViewModel(private val mainRepository: MainRepository) : ViewModel() {
    var state by mutableStateOf(CredentialsState())

    fun updateUserCredentials() {
        viewModelScope.launch {
            SetUserCredentials(mainRepository).invoke(state.email!!, state.password!!)
        }
    }
}