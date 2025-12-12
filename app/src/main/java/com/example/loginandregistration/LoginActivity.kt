package com.example.loginandregistration

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.loginandregistration.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    companion object {
        val EXTRA_USERNAME = "username"
        val EXTRA_PASSWORD = "password"
        val TAG = "LoginActivity"
    }

    val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val intent = result.data
            // Handle the Intent to whatever we need with the returned data
            binding.editTextLoginUsername.setText(intent?.getStringExtra(EXTRA_USERNAME))
            binding.editTextLoginPassword.setText(intent?.getStringExtra(EXTRA_PASSWORD))
        }
    }

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.layoutLogin) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.textViewLoginSignup.setOnClickListener {
            val username = binding.editTextLoginUsername.text.toString()
            val password = binding.editTextLoginPassword.text.toString()

            val registrationIntent = Intent(this, RegistrationActivity::class.java)

            registrationIntent.putExtra(EXTRA_USERNAME, username)
            registrationIntent.putExtra(EXTRA_PASSWORD, password)

            // startActivity(registrationIntent)

            startForResult.launch(registrationIntent)
        }
    }
}