package com.example.unittestingtutorial.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "emails")
data class EmailModel(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val email: String
)