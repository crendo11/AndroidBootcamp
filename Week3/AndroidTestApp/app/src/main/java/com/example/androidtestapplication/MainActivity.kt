package com.example.androidtestapplication

import android.Manifest
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.PermissionChecker

class MainActivity : AppCompatActivity() {
    // declare late init variables
    private lateinit var receiver: DynamicBroadcast

    // onCreated is called when the application is launched
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // this toast is not shown
        Toast.makeText(this, getString(R.string.hello_create), Toast.LENGTH_SHORT).show()

        // initialize dynamic receiver
        receiver = DynamicBroadcast()

        // register dynamic broadcast receiver
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(receiver, it)
        }

        // get the image viewer
        val viewer: ImageView = findViewById(R.id.imageViewer)

        // ask permission to read storage
        val permissionAsker =
            registerForActivityResult(ActivityResultContracts.RequestPermission())
            {   isGranted: Boolean ->
                if (isGranted){
                    getAndSetImage(viewer)
                } else {
                    // action to explain the user why the apps requires the permission
                }
            }

        // check if the activity has the correct permission
        if (PermissionChecker.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PermissionChecker.PERMISSION_GRANTED){
            getAndSetImage(viewer)
        } else {
            // ask again for storage permission
            permissionAsker.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
        }
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

        // unregister receiver to avoid error of broadcast waiting while activity is closed
        unregisterReceiver(receiver)
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this,getString(R.string.hello_destroy), Toast.LENGTH_SHORT).show()
    }

    private fun getAndSetImage(image: ImageView){
        intent?.let{ intent ->
            if (intent.action == Intent.ACTION_VIEW){
                val selectedImage: Uri? = intent.data
                image.setImageURI(selectedImage)
            }
        }
    }

}