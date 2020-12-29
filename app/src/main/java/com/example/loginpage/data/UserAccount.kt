package com.example.loginpage.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "useraccounts", indices = arrayOf(Index(value = ["email", "password"], unique = true)))
data class UserAccount (

    @ColumnInfo(name = "username")
    val username: String,

    @ColumnInfo(name = "email")
    val email: String,

    @ColumnInfo(name = "password")
    val password: String,

    @ColumnInfo(name = "confirmPassword")
    val confirmPassword: String

    ) { @PrimaryKey (autoGenerate = true) var userId: Int? = null  }


