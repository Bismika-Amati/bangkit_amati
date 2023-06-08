package com.example.amatiberkah.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.amatiberkah.R
import com.example.amatiberkah.model.remote.response.ListVillageResponse

class VillageAdapter(private val listVillage: List<ListVillageResponse>, private val onItemClick: (data: ListVillageResponse) -> Unit) : RecyclerView.Adapter<VillageAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val tvTitle: TextView = view.findViewById(R.id.village_title)
        val image: ImageView = view.findViewById(R.id.village_img)
        val tvRegion: TextView = view.findViewById(R.id.village_region)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_village, parent, false))


    override fun getItemCount() = listVillage.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val village = listVillage[position]
        holder.tvTitle.text = village.name
        Glide.with(holder.itemView.context)
            .load(village.villagePicture[0].photo)
            .into(holder.image)
        holder.tvRegion.text = village.address


        holder.itemView.setOnClickListener {onItemClick(village)}
    }

}