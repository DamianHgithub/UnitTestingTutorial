package com.example.unittestingtutorial.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.unittestingtutorial.data.EmailModel
import kotlinx.coroutines.flow.Flow

@Dao
interface MainDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertEmail(email: EmailModel)

    @Query("SELECT * FROM emails")
    fun getEmails(): Flow<List<EmailModel>>
}