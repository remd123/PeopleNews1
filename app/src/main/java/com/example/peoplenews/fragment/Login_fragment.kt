package com.example.peoplenews.fragment

import android.os.Bundle
import android.view.*
import android.view.Menu
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_login.view.*
import py.edu.uca.peoplenews.R
import java.util.zip.Inflater

class Login_fragment:Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.fragment_login,container,false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        iniciar_sesion_button.setOnClickListener {
            Toast.makeText(context,"Sesión iniciada",Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.menuPrincipal)


        }
    }



}