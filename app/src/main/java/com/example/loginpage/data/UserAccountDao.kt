package com.example.loginpage.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserAccountDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(userAccount: UserAccount)

    @Query("SELECT * FROM useraccounts WHERE useraccounts.email LIKE :email AND useraccounts.password LIKE :password LIMIT 1")
    fun getAccount(email: String, password: String): UserAccount




}