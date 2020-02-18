package com.example.peoplenews.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.peoplenews.model.ReposoModel
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.reposo_item_row.view.*
import py.edu.uca.peoplenews.R

interface ReposoInterface{
    fun ReposoClicked(reposo:ReposoModel)
}
class ReposoAdapter(val context: Context,
                    val reposos: ArrayList<ReposoModel>,
                    val listener: ReposoInterface):
    RecyclerView.Adapter<ReposoAdapter.ReposoHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ReposoHolder {
       val view= LayoutInflater.from(context).inflate(R.layout.reposo_item_row,parent,false)
        return ReposoHolder(view)
    }

    override fun getItemCount()=reposos.size

    override fun onBindViewHolder(holder: ReposoHolder, position: Int) {
        val reposo=reposos[position]
        holder.bindReposo(reposo,listener)
    }

    class ReposoHolder(val v: View):RecyclerView.ViewHolder(v){
        companion object {
            val bdUrlBase = "https://image.tmdb.org/t/p/w500"
        }


        fun bindReposo(reposo: ReposoModel,listener: ReposoInterface){
            v.motivo_reposo.text= reposo.motivo_repso
            v.fecha_sal_reposo.text=reposo.fecha_reposo

            v.setOnClickListener{
                listener.ReposoClicked(reposo)
            }



        }
    }

}