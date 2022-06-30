package com.example.notesmvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesmvvm.data.NotesModel
import com.example.notesmvvm.repository.NotesRepository
import kotlinx.coroutines.launch

class NotesViewModel(private val notesRepository: NotesRepository) : ViewModel() {

    fun getNotes(): LiveData<List<NotesModel>> {
        return notesRepository.getNotes()
    }

    fun insertNotes(notesModel: NotesModel) {
        viewModelScope.launch {
            notesRepository.insertNotes(notesModel)
        }
    }


}