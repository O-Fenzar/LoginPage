package com.example.loginpage.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.*
import com.example.loginpage.data.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    private var repository: UserDetailsRepository
    private var getAllDatas: LiveData<List<User>>

    init {

        repository = UserDetailsRepository(application)
        getAllDatas = repository.getAllData()!!
    }

    fun insert(data: User) {
        repository.insertData(data)
    }
    fun getGetAllData(): LiveData<List<User>> {
        return getAllDatas
    }
}