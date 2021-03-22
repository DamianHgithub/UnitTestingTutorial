package com.example.unittestingtutorial.di

import android.content.Context
import androidx.room.Room
import com.example.unittestingtutorial.db.MainDatabase
import com.example.unittestingtutorial.feature.MainRepository
import com.example.unittestingtutorial.feature.MainViewmodel
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val architectureModule = module {
    single { MainRepository(get()) }
    viewModel { MainViewmodel(get()) }
}
val databaseModule = module {
    single { createDatabase(androidContext()) }
    single { createDao(get()) }
}
fun createDatabase(context: Context): MainDatabase =
    Room.databaseBuilder(context, MainDatabase::class.java, "MainDatabase").build()
fun createDao(db: MainDatabase) = db.getDao()