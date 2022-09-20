package com.example.imdb_project.datalayer.databases

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.imdb_project.data.database.UserEntity

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun createUser(userEntity: UserEntity)

    @Query("Select * from UserEntity")
    fun getUsers(): List<UserEntity>

    @Query("Select * from userEntity where email LIKE :mail")
    suspend fun getUserByEmail(mail: String): UserEntity
}
