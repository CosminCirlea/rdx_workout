package com.evolutionsoftware.auther.presentation.personalInfo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.evolutionsoftware.auther.domain.repository.MainRepository
import com.evolutionsoftware.auther.domain.useCases.SetUserPersonalInfo
import kotlinx.coroutines.launch

class PersonalInfoViewModel(private val mainRepository: MainRepository) : ViewModel() {
    var state by mutableStateOf(PersonalInfoState())

    fun updateUserPersonalInfo() {
        viewModelScope.launch {
            SetUserPersonalInfo(mainRepository).invoke(state.firstName, state.name, state.phoneNumber)
        }
    }
}