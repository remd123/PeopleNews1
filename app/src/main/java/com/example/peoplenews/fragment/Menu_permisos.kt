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
class Menu_permisos : Fragment() {
    companion object{
        fun newInstance(): Menu_permisos = Menu_permisos()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu_permisos, container, false)
    }


}
