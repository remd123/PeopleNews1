package com.example.peoplenews.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.peoplenews.model.mPersona
import py.edu.uca.peoplenews.R

class PersonaAdapter(var lpersonas : ArrayList<mPersona>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
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
        val v1 = inflater.inflate(R.layout.fragment_datos_personales, parent, false)
        viewHolder = viewHolderNotificacion(v1)
        return viewHolder
    }

    override fun getItemCount(): Int {
        return if(lpersonas == null) 0 else lpersonas.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as viewHolderPersona

        holder.nombre_persona.text = lpersonas[position].nombre
        holder.apellido_persona.text = lpersonas[position].apellido
        holder.ci_persona.text = lpersonas[position].ci
        holder.direccion_persona.text = lpersonas[position].direccion
        holder.telefono_persona.text = lpersonas[position].telefono

    }


}
