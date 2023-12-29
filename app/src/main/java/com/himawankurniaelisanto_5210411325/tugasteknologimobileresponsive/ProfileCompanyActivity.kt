package com.himawankurniaelisanto_5210411325.tugasteknologimobileresponsive

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.himawankurniaelisanto_5210411325.tugasteknologimobileresponsive.databinding.ActivityProfileCompanyBinding

private lateinit var binding: ActivityProfileCompanyBinding
class ProfileCompanyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileCompanyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.location.setOnClickListener {
            val indofoodAddress = "Jl. Ipda Tut Harsono No.50-52, Muja Muju, Kec. Umbulharjo, Kota Yogyakarta, Daerah Istimewa Yogyakarta 55165"
            val uri = Uri.parse("geo:0,0?q=$indofoodAddress")
            val mapIntent = Intent(Intent.ACTION_VIEW, uri)
            mapIntent.setPackage("com.google.android.apps.maps")

            if (mapIntent.resolveActivity(packageManager) != null) {
                startActivity(mapIntent)
            } else {

            }
        }

        binding.website.setOnClickListener {
            val indofoodWebsiteUrl = "https://www.indofood.com/"
            val uri = Uri.parse(indofoodWebsiteUrl)
            val websiteIntent = Intent(Intent.ACTION_VIEW, uri)

            if (websiteIntent.resolveActivity(packageManager) != null) {
                startActivity(websiteIntent)
            } else {

            }
        }
    }
}