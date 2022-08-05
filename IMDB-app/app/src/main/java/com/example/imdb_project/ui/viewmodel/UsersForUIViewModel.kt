package com.example.imdb_project.ui.viewmodel

import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imdb_project.App
import com.example.imdb_project.R
import com.example.imdb_project.data.repositories.UsersRepositoryImpl
import com.example.imdb_project.domain.models.UserModel
import com.example.imdb_project.domain.usecases.UsersValidationForUIUseCaseImpl
import kotlinx.coroutines.launch

class UsersForUIViewModel: ViewModel() {
    private val useCase: UsersValidationForUIUseCaseImpl =
        UsersValidationForUIUseCaseImpl(UsersRepositoryImpl())

    // create live data
    private var _creationStatus = MutableLiveData<Boolean>()
    val creationStatus: LiveData<Boolean> = _creationStatus

    private var _loginStatus = MutableLiveData<Boolean>()
    val loginStatus: LiveData<Boolean> = _loginStatus

    init{
        _loginStatus.value = false
        _creationStatus.value = false
    }

    fun createUser(name: String, password: String, email: String, lastname: String){
        when {
            name.isEmpty() -> showErrorMessage(App.getContext().getString(R.string.empty_name))
            email.isEmpty() -> showErrorMessage(App.getContext().getString(R.string.empty_email))
            password.isEmpty() -> showErrorMessage(App.getContext().getString(R.string.empty_password))
            password.length < 8 -> showErrorMessage(App.getContext().getString(R.string.password_length_error))
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> showErrorMessage(App.getContext().getString(R.string.invalid_email))
            else -> {
                viewModelScope.launch {
                    try {
                        if(useCase.userExists(userMail = email)){
                            showErrorMessage(App.getContext().getString(R.string.user_exists_error))
                        } else {
                            useCase.createUser(
                                UserModel(
                                    name,
                                    password,
                                    lastname,
                                    email
                                )
                            )
                            if (useCase.validateUser(email, password)){
                                _creationStatus.value = true
                            } else {
                                showErrorMessage(App.getContext().getString(R.string.error_occurred))
                            }
                        }
                    } catch (e: Exception) {
                        Log.e("eror", e.toString())
                    }
                }
            }
        }
    }

    fun login(email: String, password: String){
        when {
            email.isEmpty() -> showErrorMessage(App.getContext().getString(R.string.empty_email))
            password.isEmpty() -> showErrorMessage(
                App.getContext().getString(R.string.empty_password)
            )
            else -> {
                viewModelScope.launch {
                    try{
                        if(useCase.validateUser( email, password)){
                            _loginStatus.value = true
                        } else {
                            showErrorMessage(App.getContext().getString(R.string.error_login))
                        }   
                    } catch (e: Exception) {
                        Log.e("eror", e.toString())
                    }
                }
            }
        }
    }

    private fun showErrorMessage(message: String) {
        val toast = Toast.makeText(
            App.getContext(),
            message,
            Toast.LENGTH_SHORT
        )
        toast.show()
    }

}