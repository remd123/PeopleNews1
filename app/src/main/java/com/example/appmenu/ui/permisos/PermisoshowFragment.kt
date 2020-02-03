package com.example.appmenu.ui.permisos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.appmenu.R

class PermisoshowFragment : Fragment() {

    private lateinit var permisoshowViewModel: PermisoshowViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        permisoshowViewModel =
            ViewModelProviders.of(this).get(PermisoshowViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_permisos, container, false)
        val textView: TextView = root.findViewById(R.id.text_permisos)
        permisoshowViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}