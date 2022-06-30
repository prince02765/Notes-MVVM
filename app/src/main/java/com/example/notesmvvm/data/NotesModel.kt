package com.example.notesmvvm.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class NotesModel(
    @PrimaryKey(autoGenerate = true)
    val uid: Int,
    val title: String
)
