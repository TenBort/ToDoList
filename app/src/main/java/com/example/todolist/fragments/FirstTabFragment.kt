package com.example.todolist.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.BaseViewModel
import com.example.todolist.R
import com.example.todolist.adapters.ToDoRecyclerAdapter
import kotlinx.android.synthetic.main.fragment_first_tab.*


class FirstTabFragment : Fragment() {
    private val adapterRecycler = ToDoRecyclerAdapter()
    private val colorsBuble = adapterRecycler.colors
    private val viewModel = context?.let { BaseViewModel(it) }


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
        checkListAdd()

        val colorsInResours = resources.getIntArray(R.array.color_list)
        colorsInResours.forEach {
            colorsBuble.add(it)
        }

        NoteAddButton.setOnClickListener {
            findNavController().navigate(R.id.action_toDoListFragment_to_noteAddFragment)
        }

    }
    fun checkListAdd() {

        viewModel?.getTask()
        viewModel?.allWords?.observe(viewLifecycleOwner, Observer {
            adapterRecycler.notifyDataSetChanged()
            adapterRecycler.list = it
        })

    }
}