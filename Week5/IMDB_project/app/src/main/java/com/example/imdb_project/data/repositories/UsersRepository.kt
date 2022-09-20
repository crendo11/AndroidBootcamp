package com.example.imdb_project.data.repositories

import com.example.imdb_project.domain.models.UserModel
import com.example.imdb_project.domain.usecases.GetUsersForUIUseCase

interface UsersRepository: GetUsersForUIUseCase {
    override fun createUser(user: UserModel)
    override fun getUserByEmail()
    override fun getUsers()
}