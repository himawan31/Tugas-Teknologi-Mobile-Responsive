package com.himawankurniaelisanto_5210411325.tugasteknologimobileresponsive

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.himawankurniaelisanto_5210411325.tugasteknologimobileresponsive.databinding.ActivityProfileEmployeesBinding

private lateinit var binding: ActivityProfileEmployeesBinding
class ProfileEmployeesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileEmployeesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.noTelp2.setOnClickListener {
            val phoneNumber = binding.noTelp2.text.toString()

            val dialIntent: Intent = Uri.parse("tel:$phoneNumber").let { number ->
                Intent(Intent.ACTION_DIAL, number)
            }

            val messageIntent: Intent = Uri.parse("sms:$phoneNumber").let { number ->
                Intent(Intent.ACTION_SENDTO, number)
            }

            val chooserIntent = Intent.createChooser(dialIntent, "Pilih aplikasi:")
            chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, arrayOf(messageIntent))

            startActivity(chooserIntent)
        }

        binding.email2.setOnClickListener {
            val emailAddress = binding.email2.text.toString()

            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:$emailAddress")
                putExtra(Intent.EXTRA_EMAIL, arrayOf(emailAddress))
            }
            startActivity(emailIntent)
        }
    }
}