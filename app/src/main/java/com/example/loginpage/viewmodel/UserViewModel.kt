package com.example.loginpage.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.loginpage.data.UserAccount
import com.example.loginpage.data.UserAccountDatabase
import com.example.loginpage.data.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(context: Context) : ViewModel() {



    private val userRepository: UserRepository
    //private val getAccount: LiveData<List<UserAccount>>

    init {

        userRepository = UserRepository.getInstance(UserAccountDatabase.getAppDatabase(context).userAccountDao())
    }

    internal  fun createUser(username: String, email: String, password: String, confirmPassword: String) {

        userRepository.insertUser(username, email, password, confirmPassword)
    }

    internal fun checkValidLogin(email: String, password: String): Boolean {

        return userRepository.isValidAccount(email, password)
    }


    class Factory internal constructor(context: Context) : ViewModelProvider.Factory {

        private val context: Context

        init {
            this.context = context.applicationContext
        }

        override fun <T : ViewModel> create(modelClass: Class<T>): T {

            return UserViewModel(context) as T
        }
    }
}