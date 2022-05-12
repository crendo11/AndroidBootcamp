package com.example.androidtestapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class StaticBroadcastReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, "test", Toast.LENGTH_SHORT).show()
        val isPhoneCharging = intent?.getBooleanExtra("state", false) ?: return
        if (isPhoneCharging){
            Toast.makeText(context, "Cargando", Toast.LENGTH_SHORT).show()
        }
    }
}