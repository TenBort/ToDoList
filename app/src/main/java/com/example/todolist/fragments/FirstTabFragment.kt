package com.example.todolist.fragments

import android.os.Bundle
import android.service.quicksettings.Tile
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.adapters.ToDoRecyclerAdapter
import com.example.todolist.R
import kotlinx.android.synthetic.main.fragment_first_tab.*

class FirstTabFragment : Fragment()
{
    val adapterRecycler = ToDoRecyclerAdapter()
    val  colorsBuble = adapterRecycler.colors

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first_tab, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        RecyclerViewFirst.layoutManager = LinearLayoutManager(context)
        RecyclerViewFirst.adapter = adapterRecycler


        val colorsInResours = resources.getIntArray(R.array.color_list)
        colorsInResours.forEach{
            colorsBuble.add(it)
        }


        NoteAddButton.setOnClickListener {
            findNavController().navigate(R.id.action_toDoListFragment_to_noteAddFragment)
        }
    }

}