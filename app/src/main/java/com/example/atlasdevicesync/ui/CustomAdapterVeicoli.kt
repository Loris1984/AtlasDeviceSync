package com.example.atlasdevicesync.ui


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.atlasdevicesync.R
import com.example.atlasdevicesync.bean.Veicoli


class CustomAdapterVeicoli(private val dataSet: Array<Veicoli>) : RecyclerView.Adapter<CustomAdapterVeicoli.CustomAdapter>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.custom_adapter_veicoli, parent, false)
        return CustomAdapter(itemView)
    }

    override fun onBindViewHolder(holder: CustomAdapter, position: Int) {
        val currentItem = dataSet[position]
        when (currentItem.tipologia) {
            "bicicletta elettrica" -> holder.icona.setBackgroundResource(R.drawable.icons_bicicletta)
            "auto elettrica" -> holder.icona.setBackgroundResource(R.drawable.icons_auto)
            "monopattino elettrico" -> holder.icona.setBackgroundResource(R.drawable.icons_monopattino)
        }
        holder.identificativo.text = currentItem.id_veicolo
        when (currentItem.stato_veicolo) {
            "disponibile" -> holder.stato.setImageResource(R.drawable.stato_disponibile)
            "in uso" -> holder.stato.setImageResource(R.drawable.stato_inuso)
            "occupato" -> holder.stato.setImageResource(R.drawable.stato_occupato)
        }
        //holder.stato.text = currentItem.stato_veicolo
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    class CustomAdapter(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val icona: ImageView = itemView.findViewById(R.id.icona_veicolo)
        val identificativo: TextView = itemView.findViewById(R.id.identificativo)
        val stato: ImageView = itemView.findViewById(R.id.stato)
    }

}