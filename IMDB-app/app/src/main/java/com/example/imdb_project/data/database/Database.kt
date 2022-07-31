package com.example.imdb_project.data.database

import android.content.Context
import androidx.room.Room

class Database {
    companion object {

        @Volatile
        private var INSTANCE: UsersDatabase? = null

        fun getInstance(context: Context): UsersDatabase {
            return INSTANCE ?: Room
                .databaseBuilder(context, UsersDatabase::class.java, "appDataBase")
                .build()
        }
    }
}