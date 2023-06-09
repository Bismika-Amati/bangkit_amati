package com.example.amatiberkah.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.amatiberkah.databinding.ItemCoursesBinding

import com.example.amatiberkah.model.remote.response.DataItem



class CourseAdapter(private val listCourse: List<DataItem>) : RecyclerView.Adapter<CourseAdapter.ViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) : ViewHolder {
        val binding = ItemCoursesBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }



    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val course = listCourse[position]
        viewHolder.binding.moduleTitle.text = course.title
        Glide.with(viewHolder.itemView.context).load(course.photo).into(viewHolder.binding.moduleImg)
        viewHolder.itemView.setOnClickListener{
            onItemClickCallback.onItemClicked(course)
        }
    }

    override fun getItemCount() = listCourse.size

    class ViewHolder(var binding: ItemCoursesBinding) :
        RecyclerView.ViewHolder(binding.root)


    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: DataItem)
    }
}