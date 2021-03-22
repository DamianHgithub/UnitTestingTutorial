package com.example.unittestingtutorial.di

import com.example.unittestingtutorial.feature.MainRepository
import com.example.unittestingtutorial.feature.MainViewmodel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val architectureModule = module {
    single { MainRepository() }
    viewModel { MainViewmodel(get()) }
}