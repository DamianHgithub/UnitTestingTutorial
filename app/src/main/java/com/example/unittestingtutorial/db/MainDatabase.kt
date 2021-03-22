package com.example.unittestingtutorial.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.unittestingtutorial.data.EmailModel

@Database(version = 1, entities = [EmailModel::class], exportSchema = false)
abstract class MainDatabase: RoomDatabase() {
    abstract fun getDao(): MainDao
}