package com.example.imdb_project.ui.presentation.fragments

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.imdb_project.App
import com.example.imdb_project.R
import com.example.imdb_project.databinding.LoginActivityBinding
import com.example.imdb_project.ui.presentation.HomeActivity
import com.example.imdb_project.ui.viewmodel.UsersForUIViewModel

class LoginActivity : AppCompatActivity(){

    private var _binding: LoginActivityBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val viewModel by viewModels<UsersForUIViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = LoginActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        subscribeToLoginLiveData()
        setUpLoginButton()
        setupRegisterButton()
    }

    private fun goToHome(){
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun goToRegister(){
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }

    private fun setUpLoginButton(){
        val loginButton = binding.loginButton
        loginButton.isEnabled = true
        loginButton.setOnClickListener{
            viewModel.login(
                email = binding.usernameInput.text.toString(),
                password = binding.passwordInput.text.toString()
            )
        }
    }

    private fun subscribeToLoginLiveData(){
        viewModel.loginStatus.observe(this){ loginStatus ->
            if (loginStatus){
                goToHome()
            }
        }
    }

    private fun setupRegisterButton(){
        val registerButton = binding.registerTextView
        registerButton.setOnClickListener{
            goToRegister()
        }
    }

}