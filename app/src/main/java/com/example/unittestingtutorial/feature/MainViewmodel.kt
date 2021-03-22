package com.example.unittestingtutorial.feature

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class MainViewmodel(
    val repository: MainRepository
): ViewModel() {

    val email = MutableStateFlow(null)
}