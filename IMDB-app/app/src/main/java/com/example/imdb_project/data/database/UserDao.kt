package com.example.imdb_project.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun createUser(userEntity: UserEntity)

    @Query("Select * from UserEntity")
    fun getUsers(): List<UserEntity>
}
