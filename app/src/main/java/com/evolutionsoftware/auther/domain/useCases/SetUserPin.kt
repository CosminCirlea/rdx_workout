package com.evolutionsoftware.auther.domain.useCases

import com.evolutionsoftware.auther.domain.repository.MainRepository

class SetUserPin(private val repository: MainRepository) {
    suspend operator fun invoke(pin: String) {
        return repository.setUserPin(pin)
    }
}