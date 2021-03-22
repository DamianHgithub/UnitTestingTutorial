package com.example.unittestingtutorial.feature

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.unittestingtutorial.data.EmailModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewmodel(
    val repository: MainRepository
): ViewModel() {
    val email: MutableStateFlow<List<EmailModel>?> = MutableStateFlow(null)
    init {
        viewModelScope.launch {
            repository.getData().collect {
                email.value = it
            }
        }
    }
    fun insertData(email: EmailModel) = viewModelScope.launch { repository.insertData(email) }
}