package com.evolutionsoftware.auther.domain.useCases

import com.evolutionsoftware.auther.domain.repository.MainRepository

class SaveUserDetails(private val repository: MainRepository) {
    suspend operator fun invoke() {
        return repository.saveUserDetails()
    }
}