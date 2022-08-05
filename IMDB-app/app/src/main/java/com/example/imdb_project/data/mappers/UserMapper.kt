package com.example.imdb_project.data.mappers

import com.example.imdb_project.data.database.UserEntity
import com.example.imdb_project.domain.models.UserModel

class UserMapper {
    fun userEntity2UserModel(user: UserEntity): UserModel{
        return UserModel(
            name = user.name,
            password = user.password,
            email = user.email,
            lastname = user.lastname
        )
    }

    fun userModel2UserEntity(user: UserModel): UserEntity{
        return UserEntity(
            name = user.name,
            password = user.password,
            email = user.email,
            lastname = user.lastname
        )
    }
}