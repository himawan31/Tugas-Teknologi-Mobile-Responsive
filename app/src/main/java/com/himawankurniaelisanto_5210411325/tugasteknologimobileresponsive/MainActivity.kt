package com.himawankurniaelisanto_5210411325.tugasteknologimobileresponsive

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.himawankurniaelisanto_5210411325.tugasteknologimobileresponsive.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val LOCATION_PERMISSION_REQUEST_CODE = 123
    private val CHARGING_STATUS_ACTION = "android.intent.action.ACTION_POWER_CONNECTED"

    private val chargingReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            if (intent?.action == CHARGING_STATUS_ACTION) {
                displayChargingMessage()
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        checkLocationPermission()

        binding.employees.setOnClickListener {
            val intent = Intent(this, ProfileEmployeesActivity::class.java)
            startActivity(intent)
        }

        binding.company.setOnClickListener {
            val intent = Intent(this, ProfileCompanyActivity::class.java)
            startActivity(intent)
        }

        val filter = IntentFilter(CHARGING_STATUS_ACTION)
        registerReceiver(chargingReceiver, filter)
    }

    private fun checkLocationPermission() {
        // Permission check for ACCESS_FINE_LOCATION and ACCESS_COARSE_LOCATION
        val fineLocationPermission =
            ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
        val coarseLocationPermission =
            ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION)

        if (fineLocationPermission != PackageManager.PERMISSION_GRANTED ||
            coarseLocationPermission != PackageManager.PERMISSION_GRANTED
        ) {
            // Request permissions
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    android.Manifest.permission.ACCESS_FINE_LOCATION,
                    android.Manifest.permission.ACCESS_COARSE_LOCATION
                ),
                LOCATION_PERMISSION_REQUEST_CODE
            )
        }
    }

    private fun displayChargingMessage() {
        Toast.makeText(this, "Baterai perangkat Anda sedang diisi", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        // Unregister BroadcastReceiver saat aktivitas dihancurkan
        unregisterReceiver(chargingReceiver)
        super.onDestroy()
    }
}