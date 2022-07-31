package com.example.imdb_project.ui.presentation.fragments

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.imdb_project.R
import com.example.imdb_project.ui.presentation.HomeActivity

class LoginActivity : AppCompatActivity(){

    private lateinit var loginButton: Button
    private lateinit var registerTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        loginButton = findViewById(R.id.login_button)
        loginButton.isEnabled = true

        // go to home activity
        loginButton.setOnClickListener{ goToHome() }

        registerTextView = findViewById(R.id.registerTextView)
        registerTextView.setOnClickListener{ goToRegister() }
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


}