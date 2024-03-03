package com.evolutionsoftware.auther.domain.useCases

import com.evolutionsoftware.auther.domain.main.UserUI
import com.evolutionsoftware.auther.domain.repository.MainRepository

class GetUserDetails(private val repository: MainRepository) {
    suspend operator fun invoke() : UserUI? {
        return repository.getUser()
    }
}