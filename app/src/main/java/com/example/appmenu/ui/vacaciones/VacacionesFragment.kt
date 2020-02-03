package com.example.appmenu.ui.vacaciones

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.appmenu.R

class VacacionesFragment : Fragment() {

    private lateinit var vacacionesViewModel: VacacionesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vacacionesViewModel =
            ViewModelProviders.of(this).get(VacacionesViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_vacaciones, container, false)
        val textView: TextView = root.findViewById(R.id.text_vacaciones)
        vacacionesViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}