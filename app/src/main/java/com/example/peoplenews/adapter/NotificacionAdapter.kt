package com.example.peoplenews.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.peoplenews.model.NotificacionModel
import kotlinx.android.synthetic.main.notificacion_item_row.view.*

import py.edu.uca.peoplenews.R

interface NotificacionInterface{
    fun NotificacionClicked(notificacion: NotificacionModel)
}
class NotificacionAdapter(val context: Context,
                    val notificaciones: ArrayList<NotificacionModel>,
                    val listener: NotificacionInterface):
    RecyclerView.Adapter<NotificacionAdapter.NotificacionHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):NotificacionHolder {
        val view= LayoutInflater.from(context).inflate(R.layout.notificacion_item_row,parent,false)
        return NotificacionHolder(view)
    }

    override fun getItemCount()=notificaciones.size

    override fun onBindViewHolder(holder: NotificacionHolder, position: Int) {
        val notificacion= notificaciones[position]
        holder.bindNotificacion(notificacion,listener)
    }

    class NotificacionHolder(val v: View): RecyclerView.ViewHolder(v){
        companion object {
            val bdUrlBase = "https://image.tmdb.org/t/p/w500"
        }


        fun bindNotificacion(notificacion: NotificacionModel, listener: NotificacionInterface){
            v.descripcion_notificacion.text= notificacion.descripcion
            //v.fecha_notificacion.text=notificacion.fecha

            v.setOnClickListener{
                listener.NotificacionClicked(notificacion)
            }



        }
    }

}