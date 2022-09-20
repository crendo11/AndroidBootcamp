package com.example.imdb_project.domain.usecases

import com.example.imdb_project.data.repositories.UsersRepository
import com.example.imdb_project.domain.models.UserModel

class UsersValidationForUIUseCaseImpl(private val usersRepository: UsersRepository):
    UsersValidationForUIUseCase {
    override suspend fun createUser(user: UserModel) {
        usersRepository.createUser(user)
    }

    override suspend fun getUserByEmail(email: String) {

    }

    override suspend fun validateUser(email: String, password: String): Boolean {
        val user = usersRepository.getUserByEmail(email)
        user?.let{
            if (it.password == password){
                return true
            }
        }
        return false
    }

    override suspend fun userExists(userMail: String):Boolean{
        val user = usersRepository.getUserByEmail(userMail)
        user?.let {
            return true
        }
        return false
    }

    override suspend fun getUsers() {
        TODO("Not yet implemented")
    }
}