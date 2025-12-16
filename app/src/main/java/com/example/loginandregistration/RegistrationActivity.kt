package com.example.loginandregistration

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.loginandregistration.databinding.ActivityRegistrationBinding

class RegistrationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.layoutRegistration) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val username = intent.getStringExtra(LoginActivity.EXTRA_USERNAME) ?: ""
        val password = intent.getStringExtra(LoginActivity.EXTRA_PASSWORD) ?: ""

        binding.editTextRegistrationUsername.setText(username)
        binding.editTextTextPassword.setText(password)

        binding.buttonRegistrationRegister.setOnClickListener {

            if (!RegistrationUtil.validateName(binding.editTextRegistrationName.text.toString())) {
                Toast.makeText(this, "Invalid Name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!RegistrationUtil.validateUsername(binding.editTextRegistrationUsername.text.toString())) {
                Toast.makeText(this, "Invalid Username", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!RegistrationUtil.validatePassword(binding.editTextTextPassword.text.toString(), binding.editTextRegistrationConfirmPassword.text.toString())) {
                Toast.makeText(this, "Invalid Password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!RegistrationUtil.validateEmail(binding.editTextRegistrationEmail.text.toString())) {
                Toast.makeText(this, "Invalid Email", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent()
            intent.putExtra(LoginActivity.EXTRA_USERNAME, binding.editTextRegistrationUsername.text.toString())
            intent.putExtra(LoginActivity.EXTRA_PASSWORD, binding.editTextTextPassword.text.toString())
            setResult(RESULT_OK, intent)
            finish()

        }
    }
}