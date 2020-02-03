package com.example.appmenu.ui.dpersonales

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.appmenu.R

class PersonalesFragment : Fragment() {

    private lateinit var personalesViewModel: PersonalesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        personalesViewModel =
            ViewModelProviders.of(this).get(PersonalesViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_datos_personales, container, false)
        val textView: TextView = root.findViewById(R.id.text_datos_personales)
        personalesViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}