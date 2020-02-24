package com.example.peoplenews.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.notificacion_item_row.view.*
import py.edu.uca.peoplenews.R

class viewHolderNotificacion(itemView: View) : RecyclerView.ViewHolder(itemView){

    val tvdescirpcion : TextView

    init{

        tvdescirpcion = itemView.findViewById(R.id.descripcion_notificacion)

    }

}