package com.example.imdb_project.domain.usecases
import com.example.imdb_project.domain.models.UserModel

interface UsersValidationForUIUseCase {
    suspend fun getUserByEmail(email: String)
    suspend fun validateUser(email: String, password: String): Boolean
    suspend fun getUsers()
    suspend fun createUser(user: UserModel)
    suspend fun userExists(userEmail: String): Boolean
}