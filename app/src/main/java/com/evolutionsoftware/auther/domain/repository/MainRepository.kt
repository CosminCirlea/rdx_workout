package com.evolutionsoftware.auther.domain.repository

import com.evolutionsoftware.auther.domain.main.UserUI

interface MainRepository {
    suspend fun getUser() : UserUI?
    suspend fun saveUserDetails()
    suspend fun resetUserDetails()
    suspend fun setUserCredentials(email: String, password: String)
    suspend fun setUserPin(pin: String)
    suspend fun setUserPersonalInfo(firstname: String, name: String, phoneNumber: String)
}