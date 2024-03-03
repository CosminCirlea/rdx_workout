package com.evolutionsoftware.auther.presentation.checkPin

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.evolutionsoftware.auther.domain.repository.MainRepository
import com.evolutionsoftware.auther.domain.useCases.GetUserDetails
import com.evolutionsoftware.auther.domain.useCases.ResetUserDetails
import com.evolutionsoftware.auther.domain.useCases.SaveUserDetails
import com.evolutionsoftware.auther.domain.useCases.SetUserPin
import com.evolutionsoftware.auther.presentation.main.MainState
import com.evolutionsoftware.auther.presentation.main.UiEvent
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class CheckPinViewModel(private val mainRepository: MainRepository) : ViewModel() {
    var state by mutableStateOf(LoginPinState())
    var event = MutableSharedFlow<UiEvent>()
        private set

    init {
        fetchUserDetails()
    }

    private fun fetchUserDetails() {
        viewModelScope.launch {
            val user = GetUserDetails(mainRepository).invoke()
            user?.let {
                state = state.copy(pin = it.pin!!)
            }
        }
    }

    fun checkPin(): Boolean {
        return state.pin == state.enteredPin
    }

    fun signOut() {
        viewModelScope.launch {
            ResetUserDetails(mainRepository).invoke()
            event.emit(UiEvent.NavigateFurther)
        }
    }
}