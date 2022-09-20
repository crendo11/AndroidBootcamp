package com.example.imdb_project.data.repositories

import com.example.imdb_project.data.database.UserEntity
import com.example.imdb_project.domain.models.UserModel

interface UsersRepository {
    suspend fun createUser(user: UserModel)
    suspend fun getUserByEmail(email: String): UserModel?
    suspend fun getUsers()

}