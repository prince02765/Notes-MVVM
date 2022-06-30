package com.example.notesmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.notesmvvm.adapter.NotesAdapter
import com.example.notesmvvm.data.NotesModel
import com.example.notesmvvm.database.NotesDB
import com.example.notesmvvm.databinding.ActivityMainBinding
import com.example.notesmvvm.repository.NotesRepository
import com.example.notesmvvm.viewmodel.NotesViewModel
import com.example.notesmvvm.viewmodel.NotesViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var noteRecycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        val notesDao = NotesDB.getDatabase(applicationContext).notesDao()
        val notesRepository = NotesRepository(notesDao)
        val notesViewModel = ViewModelProvider(
            this,
            NotesViewModelFactory(notesRepository)
        ).get(NotesViewModel::class.java)

        noteRecycler = findViewById(R.id.notes_recycler)
        val adapter = NotesAdapter()
        noteRecycler.adapter = adapter

        notesViewModel.getNotes().observe(this) {
            adapter.submitList(it)
        }

        binding.submitBtn.setOnClickListener {

            if (binding.noteEtx.text!!.isEmpty()) {
                binding.noteEtx.error = "Empty!"
            } else {
                notesViewModel.insertNotes(NotesModel(0, binding.noteEtx.text.toString()))
                Toast.makeText(this, "Note Added", Toast.LENGTH_LONG).show()
                binding.noteEtx.text = null
            }

        }

    }
}