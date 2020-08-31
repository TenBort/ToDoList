package com.example.todolist.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.BaseViewModel
import com.example.todolist.adapters.ToDoRecyclerAdapter
import com.example.todolist.R
import kotlinx.android.synthetic.main.fragment_first_tab.*


class FirstTabFragment : Fragment() {
    private val adapterRecycler = ToDoRecyclerAdapter()
    private val colorsBuble = adapterRecycler.colors
    private val viewModel: BaseViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first_tab, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        checkListAdd()
        RecyclerViewFirst.layoutManager = LinearLayoutManager(context)
        RecyclerViewFirst.adapter = adapterRecycler


        val colorsInResours = resources.getIntArray(R.array.color_list)
        colorsInResours.forEach {
            colorsBuble.add(it)
        }

        NoteAddButton.setOnClickListener {
            findNavController().navigate(R.id.action_toDoListFragment_to_noteAddFragment)
        }
    }

    fun checkListAdd() {

        viewModel.list.observe(viewLifecycleOwner, Observer {
            adapterRecycler.list = it
            adapterRecycler.notifyDataSetChanged()
        })

    }
}