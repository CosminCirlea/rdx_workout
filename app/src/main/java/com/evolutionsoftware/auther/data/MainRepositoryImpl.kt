package com.evolutionsoftware.auther.data

import android.content.Context
import android.content.SharedPreferences
import com.evolutionsoftware.auther.domain.main.UserUI
import com.evolutionsoftware.auther.domain.repository.MainRepository
import com.google.gson.Gson

class MainRepositoryImpl(context: Context) : MainRepository {
    private val USER_KEY = "userDetails"
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("userData", Context.MODE_PRIVATE)
    private val gson = Gson()
    private var user: UserUI = UserUI()

    override suspend fun getUser(): UserUI? {
        val jsonUser = sharedPreferences.getString(USER_KEY, null)
        return gson.fromJson(jsonUser, UserUI::class.java)
    }

    override suspend fun saveUserDetails() {
        val jsonUser = gson.toJson(user)
        sharedPreferences.edit().putString(USER_KEY, jsonUser).apply()
    }

    override suspend fun resetUserDetails() {
        sharedPreferences.edit().putString(USER_KEY, null).apply()
    }

    override suspend fun setUserCredentials(email: String, password: String) {
        user.email = email
        user.password = password
    }

    override suspend fun setUserPin(pin: String) {
        user.pin = pin
    }

    override suspend fun setUserPersonalInfo(firstname: String, name: String, phoneNumber: String) {
        user.firstName = firstname
        user.name = name
        user.phone = phoneNumber
    }
}