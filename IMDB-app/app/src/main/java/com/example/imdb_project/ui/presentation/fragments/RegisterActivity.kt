package com.example.imdb_project.ui.presentation.fragments

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.imdb_project.R
import com.example.imdb_project.databinding.RegisterActivityBinding
import com.example.imdb_project.ui.presentation.HomeActivity
import com.example.imdb_project.ui.viewmodel.UsersForUIViewModel

class RegisterActivity: AppCompatActivity() {

    private var _binding: RegisterActivityBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val viewModel by viewModels<UsersForUIViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = RegisterActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        subscribeToUserCreation()
        setUpRegisterButton()

    }

    private fun subscribeToUserCreation(){
        viewModel.creationStatus.observe(this){ creationStatus ->
            if (creationStatus){
                Toast.makeText(this, getString(R.string.can_sign_in), Toast.LENGTH_LONG).show()
                // navigate to sign in
                goToSignIn()
            }
        }
    }

    private fun setUpRegisterButton(){
        val registerButton = binding.registerButton
        registerButton.setOnClickListener{
            viewModel.createUser(
                name = binding.nameInput.text.toString(),
                password = binding.passwordInput.text.toString(),
                email = binding.emailInput.text.toString(),
                lastname = "lastname"
            )
        }
    }

    private fun goToSignIn(){
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}