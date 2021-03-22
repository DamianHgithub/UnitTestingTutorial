package com.example.unittestingtutorial.di

import android.app.Application
import androidx.datastore.preferences.preferencesDataStore
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DIManager: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@DIManager)
            modules(listOf(
                architectureModule
            ))
        }
    }
}