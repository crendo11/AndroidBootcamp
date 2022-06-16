package com.example.imdb_project.ui

import android.content.Intent
import kotlin.concurrent.schedule
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.imdb_project.LoginActivity
import com.example.imdb_project.R
import java.util.*


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        Timer("SettingUp", false).schedule(1500){
            goToLogin()
        }
    }

    private fun goToLogin(){
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}