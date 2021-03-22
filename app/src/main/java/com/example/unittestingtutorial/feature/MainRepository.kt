package com.example.unittestingtutorial.feature

import com.example.unittestingtutorial.data.EmailModel
import com.example.unittestingtutorial.db.MainDao
import kotlinx.coroutines.flow.Flow

class MainRepository(
    val dao: MainDao
) {
    suspend fun insertData(email: EmailModel) = dao.insertEmail(email)
    fun getData(): Flow<List<EmailModel>> = dao.getEmails()
}
