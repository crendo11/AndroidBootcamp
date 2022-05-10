package com.example.androidtestapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

// declare

class MainActivity : AppCompatActivity() {
    // onCreated is called when the application is launched
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // this toast is not shown
        Toast.makeText(this, getString(R.string.hello_create), Toast.LENGTH_SHORT).show()
    }

    //
    override fun onStart(){
        super.onStart()
        Toast.makeText(this,getString(R.string.hello_start), Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this,getString(R.string.hello_resume), Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this,getString(R.string.hello_pause), Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this,getString(R.string.hello_stop), Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this,getString(R.string.hello_destroy), Toast.LENGTH_SHORT).show()
    }

}