package com.example.peoplenews.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import py.edu.uca.peoplenews.R

/**
 * A simple [Fragment] subclass.
 */
class FormReposoFragment : Fragment() {
    var idPermiso: Int = -1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_form_reposo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val arguments = FormReposoFragmentArgs.fromBundle(it)
            idPermiso = arguments.idPermiso

            Toast.makeText(context, "El id del permiso es $idPermiso", Toast.LENGTH_LONG).show()
        }
    }


}
