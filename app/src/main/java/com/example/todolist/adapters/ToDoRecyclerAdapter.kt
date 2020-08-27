package com.example.todolist.adapters

import android.icu.text.CaseMap
import android.service.quicksettings.Tile
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.model.DataItem
import com.example.todolist.R


class ToDoRecyclerAdapter() :
    RecyclerView.Adapter<ToDoRecyclerAdapter.MyViewHolder>() {

    var colors = mutableListOf<Int>()
    val list: List<DataItem> = listOf<DataItem>(
        DataItem(
            "27.08.2020",
            "StartTest",
            "Hoh man"
        ),
        DataItem(
            "07.12.1998",
            "Shit its Jason BORNing",
            "yyyyyyyyyyyyyyyyyyyyyyy"
        ),
        DataItem(
            "07.12.1998",
            "Shit its Jason BORNing",
            "yyyyyyyyyyyyyyyyyyyyyyy"
        ),
        DataItem(
            "07.12.1998",
            "Shit its Jason BORNing",
            "yyyyyyyyyyyyyyyyyyyyyyy"
        ),
        DataItem(
            "07.12.1998",
            "Shit its Jason BORNing",
            "yyyyyyyyyyyyyyyyyyyyyyy"
        )
        ,
        DataItem(
            "07.12.1998",
            "Shit its Jason BORNing",
            "yyyyyyyyyyyyyyyyyyyyyyy"
        )
        ,
        DataItem(
            "07.12.1998",
            "Shit its Jason BORNing",
            "yyyyyyyyyyyyyyyyyyyyyyy"
        )
        ,
        DataItem(
            "07.12.1998",
            "Shit its Jason BORNing",
            "yyyyyyyyyyyyyyyyyyyyyyy"
        )
        ,
        DataItem(
            "07.12.1998",
            "Shit its Jason BORNing",
            "yyyyyyyyyyyyyyyyyyyyyyy"
        )
        ,
        DataItem(
            "07.12.1998",
            "Shit its Jason BORNing",
            "yyyyyyyyyyyyyyyyyyyyyyy"
        )
        ,
        DataItem(
            "07.12.1998",
            "Shit its Jason BORNing",
            "yyyyyyyyyyyyyyyyyyyyyyy"
        )
        ,
        DataItem(
            "07.12.1998",
            "Shit its Jason BORNing",
            "yyyyyyyyyyyyyyyyyyyyyyy"
        )
        ,
        DataItem(
            "07.12.1998",
            "Shit its Jason BORNing",
            "yyyyyyyyyyyyyyyyyyyyyyy"
        )
    )


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ToDoRecyclerAdapter.MyViewHolder {

        val itemView = LayoutInflater.from(parent.context)
        val item = itemView.inflate(R.layout.recycler_item, parent, false)
        return MyViewHolder(item)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        if (position < 20) {
            holder.cardView.setCardBackgroundColor(colors[position])
        }else{
            holder.cardView.setCardBackgroundColor(colors.random())
        }

        holder.textContainer.text = list[position].date
        holder.textContainer2.text = list[position].name
    }

    override fun getItemCount() = list.size


    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var textContainer = view.findViewById<TextView>(R.id.textViewItem)
        var textContainer2 = view.findViewById<TextView>(R.id.textViewItem2)
        var cardView = view.findViewById<CardView>(R.id.card_view)

    }
}




