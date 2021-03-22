package com.example.unittestingtutorial.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MainDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertEmail(email: String)

    @Query("SELECT * FROM emails")
    fun getEmails(): Flow<List<String>>
}