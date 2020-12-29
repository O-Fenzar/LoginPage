package com.example.loginpage.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DaoAccess {

    @Insert
    fun insertUserData(user: User)  //   query is written above for insert all details of user

    @Query("select * from User")
    fun getDetails(): LiveData<List<User>> //   query is written above for fetching all details of user

    @Query("DELETE FROM User WHERE id = :id")
    fun deleteByUserId(id: Long)   //  do it by your own for practise  query is written above

    /*@Query("SELECT * FROM useraccounts WHERE useraccounts.email LIKE :email AND useraccounts.password LIKE :password LIMIT 1")
    fun getAccount(email: String, password: String): UserAccount*/




}