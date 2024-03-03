package com.evolutionsoftware.auther.domain.useCases

import com.evolutionsoftware.auther.domain.repository.MainRepository

class ResetUserDetails(private val repository: MainRepository) {
    suspend operator fun invoke() {
        return repository.saveUserDetails()
    }
}