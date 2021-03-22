package com.example.unittestingtutorial.feature

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.lifecycleScope
import com.example.unittestingtutorial.databinding.ActivityMainBinding
import com.example.unittestingtutorial.util.EmailValidator
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity: AppCompatActivity() {
    private val viewmodel by viewModel<MainViewmodel>()
    lateinit var binding: ActivityMainBinding
    val datastore by preferencesDataStore("EmailDatastore")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupListeners()
    }
    private fun setupListeners() {
        binding.btnCheckemail.setOnClickListener {
            if (EmailValidator().isValid(binding.inputEmail.text.toString())) {
                Snackbar.make(binding.root, "Email is valid.", Snackbar.LENGTH_SHORT).show()
                lifecycleScope.launch {
                    writeToDatastore(binding.inputEmail.text.toString())
                }
            }
            else binding.inputEmail.error = "Email is not valid."
        }
        binding.btnGetemail.setOnClickListener {
            lifecycleScope.launch {
                if (getFromDatastore() == null) Snackbar.make(binding.root, "There is no valid email to retrieve.", Snackbar.LENGTH_SHORT).show()
                else binding.textEmail.text = getFromDatastore()
            }
        }
    }
    private suspend fun writeToDatastore(email: String) {
        val key = stringPreferencesKey("LastEmail")
        datastore.edit {
            it[key] = email
        }
    }
    private suspend fun getFromDatastore(): String? {
        val key = stringPreferencesKey("LastEmail")
        return datastore.data.first()[key]
    }
}