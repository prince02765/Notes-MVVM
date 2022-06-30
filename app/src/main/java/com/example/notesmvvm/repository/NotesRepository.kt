package com.example.notesmvvm.repository

import androidx.lifecycle.LiveData
import com.example.notesmvvm.dao.NotesDAO
import com.example.notesmvvm.data.NotesModel

class NotesRepository(private val notesDAO: NotesDAO) {

    suspend fun insertNotes(notesModel: NotesModel) {
        notesDAO.insertNote(notesModel)
    }

    fun getNotes(): LiveData<List<NotesModel>> {
        return notesDAO.getNotes()
    }

}