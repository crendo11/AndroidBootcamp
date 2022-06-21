package com.example.imdb_project.ui.presentation.fragments

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.imdb_project.R
import com.example.imdb_project.ui.presentation.HomeActivity

class LoginActivity : AppCompatActivity(){

    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        loginButton = findViewById(R.id.login_button)
        loginButton.isEnabled = true

        // go to home activity
        loginButton.setOnClickListener{ goToHome() }
    }

    private fun goToHome(){
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }


}