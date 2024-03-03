package com.evolutionsoftware.auther.domain.useCases

import com.evolutionsoftware.auther.domain.repository.MainRepository

class SetUserPersonalInfo(private val repository: MainRepository) {
    suspend operator fun invoke(firstname: String, name: String, phoneNumber: String) {
        return repository.setUserPersonalInfo(firstname, name,phoneNumber)
    }
}