package com.example.imdb_project.datalayer.databases

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.imdb_project.data.database.UserDao
import com.example.imdb_project.data.database.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object{
        @Volatile private var instance: UserDatabase ?= null

        fun getInstance(context: Context): UserDatabase{
            return instance ?: synchronized(this){
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): UserDatabase{
            return Room.databaseBuilder(
                context.applicationContext,
                UserDatabase::class.java,
                "userDatabase"
            ).build()
        }
    }
}