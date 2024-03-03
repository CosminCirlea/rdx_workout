package com.evolutionsoftware.auther.domain.useCases

import com.evolutionsoftware.auther.domain.repository.MainRepository

class SetUserCredentials(private val repository: MainRepository) {
    suspend operator fun invoke(email: String, password: String) {
        return repository.setUserCredentials(email, password)
    }
}