package com.example.notesmvvm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.notesmvvm.R
import com.example.notesmvvm.data.NotesModel

class NotesAdapter : ListAdapter<NotesModel, NotesAdapter.NotesViewHolder>(NotesDiffUtil()) {

    class NotesDiffUtil : DiffUtil.ItemCallback<NotesModel>() {
        override fun areItemsTheSame(oldItem: NotesModel, newItem: NotesModel): Boolean {
            return oldItem.uid == newItem.uid
        }

        override fun areContentsTheSame(oldItem: NotesModel, newItem: NotesModel): Boolean {
            return oldItem == newItem
        }

    }


    class NotesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val noteTitle = view.findViewById<TextView>(R.id.note_title)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        return NotesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
        )
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        holder.noteTitle.text = getItem((position)).title
    }

}