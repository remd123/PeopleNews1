package com.example.appmenu.ui.estadoSolicitud

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.appmenu.R

class EstadoSolicitudFragment : Fragment() {

    private lateinit var estadoSolicitudViewModel: EstadoSolicitudViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        estadoSolicitudViewModel =
            ViewModelProviders.of(this).get(EstadoSolicitudViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_estado_solicitud, container, false)
        val textView: TextView = root.findViewById(R.id.text_estado_solicitud)
        estadoSolicitudViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}