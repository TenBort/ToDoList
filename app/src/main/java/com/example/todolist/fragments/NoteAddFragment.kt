package com.example.todolist.fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.example.todolist.R
import com.example.todolist.adapters.ToDoRecyclerAdapter
import com.example.todolist.model.DataItem
import kotlinx.android.synthetic.main.fragment_note_add.*


class NoteAddFragment : Fragment() {

    val adapterRecycler = ToDoRecyclerAdapter()
    val  colorsBuble = adapterRecycler.list
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_note_add, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }


}



