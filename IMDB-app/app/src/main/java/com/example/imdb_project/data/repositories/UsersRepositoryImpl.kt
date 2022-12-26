package com.example.imdb_project.data.repositories

import com.example.imdb_project.App
import com.example.imdb_project.data.database.UserDatabase
import com.example.imdb_project.data.mappers.UserMapper
import com.example.imdb_project.domain.models.UserModel

class UsersRepositoryImpl: UsersRepository {
    override suspend fun createUser(user: UserModel) {
        val userMapper = UserMapper()
        val userEntity =  userMapper.userModel2UserEntity(user)
        UserDatabase.getInstance(App.getContext()).userDao().createUser(userEntity)
    }

    override suspend fun getUserByEmail(email: String): UserModel {
        val user = UserDatabase.getInstance(App.getContext()).userDao().getUserByEmail(email)
        return run {
            val userMapper = UserMapper()
            userMapper.userEntity2UserModel(user)
        }
    }

    override suspend fun getUsers() {
        TODO("Not yet implemented")
    }
}