package com.example.notesmvvm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.notesmvvm.repository.NotesRepository

class NotesViewModelFactory(private val notesRepository: NotesRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NotesViewModel(notesRepository) as T
    }

}