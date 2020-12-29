package com.example.loginpage.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(UserAccount::class), version = 1, exportSchema = false)
abstract class UserAccountDatabase : RoomDatabase() {

    abstract fun userAccountDao(): UserAccountDao

    companion object {

        @Volatile
        private var INSTANCE: UserAccountDatabase? = null

        fun getAppDatabase(context: Context): UserAccountDatabase {

            if (INSTANCE == null) {

                INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                UserAccountDatabase::class.java,
                "user_database")

                    .allowMainThreadQueries()
                    .build()
            }

            return INSTANCE!!

        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }

}