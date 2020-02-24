package com.example.peoplenews.request

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.Observable
import com.example.peoplenews.model.mNotificacion
import kotlinx.android.synthetic.main.notificacion_item_row.view.*
import py.edu.uca.peoplenews.R
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.Path
import java.util.*
import kotlin.collections.ArrayList

interface rNotificacionInterfase {

    fun NotificacionClicked(notificacion: mNotificacion)
}
//class rNotificacion1(val context: Context,
//                    val notificaciones: ArrayList<mNotificacion>,
//                    val listener: NotificacionInterfase
//):
//RecyclerView.Adapter<rNotificacion.NotificacionHolder>() {
//    override fun getItemCount()=notificaciones.size
//
//    override fun onBindViewHolder(holder: NotificacionHolder, position: Int) {
//        val notificacion= notificaciones[position]
//        holder.bindNotificacion(notificacion,listener)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificacionHolder {
//        val view =
//            LayoutInflater
//                .from(context).inflate(R.layout.notificacion_item_row, parent, false)
//
//        return NotificacionHolder(view)
//    }
//
//    class NotificacionHolder(val v: View): RecyclerView.ViewHolder(v){
//        fun bindNotificacion(notificacion: mNotificacion,listener: NotificacionInterfase){
//            v.descripcion_notificacion.text= notificacion.descripcion
//            v.fecha_notificacion.text= notificacion.fecha
//
//            v.setOnClickListener {
//                listener.NotificacionClicked(notificacion)
//            }
//        }
//    }
//
//
//}
//
//
