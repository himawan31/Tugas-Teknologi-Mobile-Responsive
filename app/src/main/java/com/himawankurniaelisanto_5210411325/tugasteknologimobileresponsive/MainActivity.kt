package com.himawankurniaelisanto_5210411325.tugasteknologimobileresponsive

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.himawankurniaelisanto_5210411325.tugasteknologimobileresponsive.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.employees.setOnClickListener {
            val intent = Intent(this, ProfileEmployeesActivity::class.java)
            startActivity(intent)
        }

        binding.company.setOnClickListener {
            val intent = Intent(this, ProfileCompanyActivity::class.java)
            startActivity(intent)
        }
    }
}