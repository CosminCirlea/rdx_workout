package com.evolutionsoftware.auther.presentation.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.evolutionsoftware.auther.domain.repository.MainRepository
import com.evolutionsoftware.auther.domain.useCases.GetUserDetails
import com.evolutionsoftware.auther.domain.useCases.ResetUserDetails
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {
    var state by mutableStateOf(MainState())
        private set
    var event = MutableSharedFlow<UiEvent>()
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

    fun signOut() {
        viewModelScope.launch {
            ResetUserDetails(mainRepository).invoke()
            event.emit(UiEvent.NavigateFurther)
        }
    }
}

sealed class UiEvent {
    object NavigateFurther : UiEvent()
}