package com.example.appmenu.ui.reposos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.appmenu.R

class RepososFragment : Fragment() {

    private lateinit var repososViewModel: RepososViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        repososViewModel =
            ViewModelProviders.of(this).get(RepososViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_reposos, container, false)
        val textView: TextView = root.findViewById(R.id.text_reposos)
        repososViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}