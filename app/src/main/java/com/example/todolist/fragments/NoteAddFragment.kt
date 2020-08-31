package com.example.todolist.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.todolist.BaseViewModel
import com.example.todolist.R
import com.example.todolist.adapters.ToDoRecyclerAdapter
import com.example.todolist.model.Task
import kotlinx.android.synthetic.main.fragment_note_add.*
import java.util.Observer


class NoteAddFragment : Fragment() {
    val viewModel = BaseViewModel()
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
        buttonOK.setOnClickListener{
            viewModel.saveTask(Task(date = editTextDate.text.toString(),name = editTextNameItem.text.toString(),description = editTextDescriptionItem.text.toString()))
            findNavController().navigate(R.id.action_noteAddFragment_to_toDoListFragment)
        }

    }


}



