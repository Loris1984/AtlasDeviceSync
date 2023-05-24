package com.example.atlasdevicesync.ui


import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.atlasdevicesync.R
import com.example.atlasdevicesync.bean.Punteggio


class CustomAdapter(private val dataSet: Array<Punteggio>) : RecyclerView.Adapter<CustomAdapter.CustomAdapter>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.custom_adapter, parent, false)
        return CustomAdapter(itemView)
    }

    override fun onBindViewHolder(holder: CustomAdapter, position: Int) {
        val currentItem = dataSet[position]
        holder.posizione.text = currentItem._id
        holder.punti.text = currentItem.tot_punti.toString() + " Punti"
        if(currentItem.isUtente) {
            holder.posizione.setTypeface(null, Typeface.BOLD);
            holder.punti.setTypeface(null, Typeface.BOLD);
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    class CustomAdapter(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val posizione: TextView = itemView.findViewById(R.id.posizione)
        val punti: TextView = itemView.findViewById(R.id.punti)
    }

}