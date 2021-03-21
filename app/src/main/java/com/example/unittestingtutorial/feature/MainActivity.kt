package com.example.unittestingtutorial.feature

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.unittestingtutorial.R
import com.example.unittestingtutorial.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}