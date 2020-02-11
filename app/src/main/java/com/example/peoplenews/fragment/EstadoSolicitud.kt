package com.example.peoplenews.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import py.edu.uca.peoplenews.R

/**
 * A simple [Fragment] subclass.
 */
class EstadoSolicitud : Fragment() {
    companion object{
        fun newInstance(): EstadoSolicitud = EstadoSolicitud()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_estado_solicitud, container, false)
    }


}
