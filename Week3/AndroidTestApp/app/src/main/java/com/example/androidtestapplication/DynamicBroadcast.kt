package com.example.androidtestapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast


class DynamicBroadcast: BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        // get the boolean variable
        val isAirplaneModeEnabled = intent?.getBooleanExtra("state", false) ?: return
        if (isAirplaneModeEnabled){
            Toast.makeText(context,
                context?.getString(R.string.airplane_mode_enabled)?: "no text",
                Toast.LENGTH_SHORT).show()
        } else{
            Toast.makeText(context,
                context?.getString(R.string.airplane_mode_disabled)?: "no text",
            Toast.LENGTH_SHORT).show()
        }
    }

}