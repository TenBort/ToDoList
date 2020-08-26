package com.example.todolist.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R


class DoneRecyclerAdapter() :
    RecyclerView.Adapter<DoneRecyclerAdapter.MyViewHolder>() {

    val List = listOf("Кушатсь", "Душ", "Рибалка", "Обнымашки", "Опять покушатс")


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DoneRecyclerAdapter.MyViewHolder {

        val itemView = LayoutInflater.from(parent.context)
        val item = itemView.inflate(R.layout.recycler_item, parent, false)
        return MyViewHolder(item)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.textContainer.text = List[position]
    }

    override fun getItemCount() = List.size


    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val textContainer = view.findViewById<TextView>(R.id.textViewItem)
    }
}




