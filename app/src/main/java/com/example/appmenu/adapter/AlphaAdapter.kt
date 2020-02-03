package com.example.appmenu.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.appmenu.R
import com.example.appmenu.model.AlphaChart

class AlphaAdapter(var context: Context, var arrayList: ArrayList<AlphaChart>):
    RecyclerView.Adapter<AlphaAdapter.ItemHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ItemHolder {

        val itemHolder= LayoutInflater.from(parent.context).inflate(R.layout.grid_layout_list_item, parent,false)
        return ItemHolder(itemHolder)
    }

    override fun getItemCount(): Int {

        return arrayList.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {

        var alphaChart: AlphaChart= arrayList.get(position)
        holder.icons.setImageResource(alphaChart.iconsChart!!)
        holder.alphas.text=alphaChart.alphaChart

        holder.alphas.setOnClickListener {
            Toast.makeText(context,alphaChart.alphaChart,Toast.LENGTH_LONG).show()
        }
    }

    class ItemHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var icons= itemView.findViewById<ImageView>(R.id.icon_image)
        var alphas= itemView.findViewById<TextView>(R.id.alpha_text_view)
    }

}