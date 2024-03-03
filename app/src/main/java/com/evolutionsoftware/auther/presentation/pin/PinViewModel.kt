package com.evolutionsoftware.auther.presentation.pin

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.evolutionsoftware.auther.domain.repository.MainRepository
import com.evolutionsoftware.auther.domain.useCases.SaveUserDetails
import com.evolutionsoftware.auther.domain.useCases.SetUserPin
import com.evolutionsoftware.auther.presentation.main.UiEvent
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class PinViewModel(private val mainRepository: MainRepository) : ViewModel() {
    var state by mutableStateOf(PinState())
    var event = MutableSharedFlow<UiEvent>()

    fun saveUser() {
        viewModelScope.launch {
            SetUserPin(mainRepository).invoke(state.pin)
            SaveUserDetails(mainRepository).invoke()
            event.emit(UiEvent.NavigateFurther)
        }
    }
}