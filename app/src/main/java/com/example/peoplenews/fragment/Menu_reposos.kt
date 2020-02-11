package com.example.peoplenews.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_menu_reposos.*
import py.edu.uca.peoplenews.R

/**
 * A simple [Fragment] subclass.
 */
class Menu_reposos : Fragment() {
    companion object{
        fun newInstance(): Menu_reposos = Menu_reposos()
    }

    enum class PERMISOS(val value: Int) {
        MATERNIDAD(1),
        PATERNIDAD(2),
        ACCIDENTE(3)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu_reposos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button_maternidad.setOnClickListener {
            moverAFormulario(PERMISOS.MATERNIDAD.value)
        }

        btnPaternidad.setOnClickListener {
            moverAFormulario(PERMISOS.PATERNIDAD.value)
        }
        btnAccidente.setOnClickListener {
            moverAFormulario(PERMISOS.ACCIDENTE.value)
        }
    }

    private fun moverAFormulario(value: Int) {
        val action = Menu_repososDirections.actionMenuReposos2ToFormReposoFragment(value)
        findNavController().navigate(action)

    }

}
