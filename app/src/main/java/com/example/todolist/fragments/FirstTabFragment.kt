package com.example.todolist.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.BaseViewModel
import com.example.todolist.R
import com.example.todolist.adapters.ToDoRecyclerAdapter
import com.example.todolist.model.Task
import kotlinx.android.synthetic.main.fragment_first_tab.*
import kotlinx.android.synthetic.main.recycler_item.*


class FirstTabFragment : Fragment() {
    private val adapterRecycler = ToDoRecyclerAdapter(::deleteClicked, ::detailClicked)
    private val colorsBubble = adapterRecycler.colors
    private val viewModel: BaseViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first_tab, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val llm = LinearLayoutManager(this.context)

        RecyclerViewFirst.layoutManager = llm
        RecyclerViewFirst.adapter = adapterRecycler
        observeLiveData()

        val colorsInResours = resources.getIntArray(R.array.color_list)
        colorsInResours.forEach {
            colorsBubble.add(it)
        }
        NoteAddButton.setOnClickListener {
            findNavController().navigate(R.id.action_toDoListFragment_to_noteAddFragment)
        }

    }

    private fun deleteClicked(task: Task) {
        viewModel.deleteTask(task)
    }

    private fun detailClicked(task: Task) {
        viewModel.detailView(task)
        findNavController().navigate(R.id.action_toDoListFragment_to_detailFragment)
    }

    private fun observeLiveData() {
        viewModel.getTask()

        viewModel.taskListLiveData.observe(viewLifecycleOwner, Observer {
            adapterRecycler.itemList = it as MutableList<Task>
            adapterRecycler.notifyDataSetChanged()

        })

    }
}