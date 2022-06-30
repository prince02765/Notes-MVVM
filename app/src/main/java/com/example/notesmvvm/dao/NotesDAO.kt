package com.example.notesmvvm.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.notesmvvm.data.NotesModel

@Dao
interface NotesDAO {

    @Insert
    suspend fun insertNote(note: NotesModel)

    @Delete
    suspend fun deleteNote(note: NotesModel)

    @Query("SELECT * FROM notes")
    fun getNotes(): LiveData<List<NotesModel>>

}