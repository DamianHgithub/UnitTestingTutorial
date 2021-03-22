package com.example.unittestingtutorial.feature

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.unittestingtutorial.R
import com.example.unittestingtutorial.databinding.ActivityMainBinding
import com.example.unittestingtutorial.util.EmailValidator
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val datastore: DataStore<Preferences> by preferencesDataStore("EmailDatastore")
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
    private suspend fun writeToDatastore(email: String) {
        val key = stringPreferencesKey("LastEmail")
        datastore.edit {
            it[key] = email
        }
    }
    private suspend fun getFromDatastore(email: String): String? {
        val key = stringPreferencesKey("LastEmail")
        return datastore.data.first()[key]
    }
}