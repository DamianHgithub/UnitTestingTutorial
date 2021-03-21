package com.example.unittestingtutorial.feature

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.unittestingtutorial.R
import com.example.unittestingtutorial.databinding.ActivityMainBinding
import com.example.unittestingtutorial.util.EmailValidator
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCheckemail.setOnClickListener {
            if (EmailValidator().isValid(binding.inputEmail.text.toString()))
                Snackbar.make(binding.root, "Email is valid.", Snackbar.LENGTH_SHORT).show()
            else binding.inputEmail.error = "Email is not valid."
        }
    }
}