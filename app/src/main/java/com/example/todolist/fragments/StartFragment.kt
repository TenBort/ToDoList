package com.example.todolist.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.todolist.R
import kotlinx.android.synthetic.main.fragment_start.*


class StartFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_start, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginButton.setOnClickListener {
            if (LoginDB.text.toString() == "1111" && PasswordDB.text.toString() == "1111") {
                onLogIn()
            } else {
                Toast.makeText(context, "Error login and password", Toast.LENGTH_SHORT)
            }

        }
    }

    private fun onLogIn() {
        findNavController().navigate(R.id.action_startFragment_to_toDoListFragment)
    }

}