package com.example.imdb_project.domain.usecases

import com.example.imdb_project.domain.models.UserModel

interface GetUsersForUIUseCase {
    fun getUserByEmail()
    fun getUsers()
    fun createUser(user: UserModel)
}