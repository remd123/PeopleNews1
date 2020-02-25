package com.example.peoplenews.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import py.edu.uca.peoplenews.R

class viewHolderPersona(itemView: View) : RecyclerView.ViewHolder(itemView){

    val nombre_persona : TextView
    val apellido_persona : TextView
    val ci_persona : TextView
    val direccion_persona : TextView
    val telefono_persona : TextView


    init{

        nombre_persona = itemView.findViewById(R.id.nombre_persona)
        apellido_persona = itemView.findViewById(R.id.apellido_persona)
        ci_persona = itemView.findViewById(R.id.documento_persona)
        direccion_persona = itemView.findViewById(R.id.direccion_persona)
        telefono_persona = itemView.findViewById(R.id.telefono_persona)

    }

}