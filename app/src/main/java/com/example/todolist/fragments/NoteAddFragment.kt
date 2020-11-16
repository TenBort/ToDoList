package com.example.todolist.fragments

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.todolist.BaseViewModel
import com.example.todolist.R
import com.example.todolist.adapters.ToDoRecyclerAdapter
import com.example.todolist.model.Task
import com.example.todolist.repo.TaskRepository
import kotlinx.android.synthetic.main.fragment_note_add.*
import java.util.*


class NoteAddFragment : Fragment() {
    private val viewModel: BaseViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_note_add, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonOK.setOnClickListener {
            saveTask()
        }
    }

    private fun saveTask() {
        val name = editTextNameItem.text.toString()
        val date = editTextDate.text.toString()
        val description = editTextDescriptionItem.text.toString()

        if (name.isBlank() || date.isBlank() || description.isBlank()) {
            Toast.makeText(context, "Enter text", Toast.LENGTH_SHORT).show()
            return
        }
        val task = Task(date = date, name = name, description = description,importent = false)
        viewModel.setTask(task)
        closeKeyboard()
        findNavController().popBackStack()
    }

    private fun closeKeyboard() {
        val imm: InputMethodManager =
            activity?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view?.windowToken, 0)
    }


}



