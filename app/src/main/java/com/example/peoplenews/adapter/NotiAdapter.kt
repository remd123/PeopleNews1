package com.example.peoplenews.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.peoplenews.model.mNotificacion
import py.edu.uca.peoplenews.R

class NotiAdapter(var lnotificaciones : ArrayList<mNotificacion>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val viewHolder: RecyclerView.ViewHolder

        val inflater = LayoutInflater.from(parent.context)

        viewHolder = getViewHolder(parent, inflater)


        return viewHolder
    }

    private fun getViewHolder(
        parent: ViewGroup,
        inflater: LayoutInflater
    ): RecyclerView.ViewHolder {
        val viewHolder: RecyclerView.ViewHolder
        val v1 = inflater.inflate(R.layout.notificacion_item_row, parent, false)
        viewHolder = viewHolderNotificacion(v1)
        return viewHolder
    }

    override fun getItemCount(): Int {
        return if(lnotificaciones == null) 0 else lnotificaciones.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        holder as viewHolderNotificacion

        holder.tvdescirpcion.text = lnotificaciones[position].descripcion



    }


}