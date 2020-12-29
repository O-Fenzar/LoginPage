package com.example.loginpage.data

import androidx.lifecycle.LiveData

class UserRepository(private val userAccountDao: UserAccountDao) {

    private val userAccountLiveData: LiveData<UserAccount>? = null

    fun addUser(userAccount: UserAccount){
        userAccountDao.insert(userAccount)
    }

    fun isValidAccount(email: String, password: String): Boolean {

        val userAccount = userAccountDao.getAccount(email, password)
        return userAccount.password == password
    }

    fun insertUser(username: String, email :String, password: String, confirmPassword: String) {
        val userAccount = UserAccount(username, email, password, confirmPassword)
        userAccountDao.insert(userAccount)
    }

    companion object {

        private var instance: UserRepository? = null

        fun getInstance(userAccountDao: UserAccountDao): UserRepository {

            if (instance == null) {

                instance = UserRepository(userAccountDao)
            }
            return instance!!
        }
    }
}