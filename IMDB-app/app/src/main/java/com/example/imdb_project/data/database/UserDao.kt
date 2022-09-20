package com.example.imdb_project.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createUser(userEntity: UserEntity)

    @Query("Select * from UserEntity")
    suspend fun getUsers(): List<UserEntity>

    @Query("Select * from userEntity where email LIKE :mail")
    suspend fun getUserByEmail(mail: String): UserEntity
}
