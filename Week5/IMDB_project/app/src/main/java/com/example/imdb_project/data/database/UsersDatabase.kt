package com.example.imdb_project.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UserEntity::class], version = 1)
abstract class UsersDatabase: RoomDatabase() {
    abstract val userEntityDao: UserDao
}
