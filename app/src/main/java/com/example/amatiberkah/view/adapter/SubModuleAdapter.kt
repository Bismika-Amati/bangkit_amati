package com.example.amatiberkah.view.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.amatiberkah.databinding.ItemSubmoduleBinding
import com.example.amatiberkah.model.remote.response.Data
import com.example.amatiberkah.model.remote.response.SubModuleItem

class SubModuleAdapter(private val listSubModule: List<SubModuleItem>): RecyclerView.Adapter<SubModuleAdapter.ViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) : ViewHolder {
        val binding = ItemSubmoduleBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }



    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val course = listSubModule[position]
        viewHolder.binding.tvStudyPrepare.text = course.title
        viewHolder.binding.tvCourseTime.text = course.number.toString()
        Glide.with(viewHolder.itemView.context).load(course.picture).into(viewHolder.binding.ivCourse)
        viewHolder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(course)
        }
    }

    override fun getItemCount() = listSubModule.size

    class ViewHolder(var binding: ItemSubmoduleBinding) :
        RecyclerView.ViewHolder(binding.root)


    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: SubModuleItem)
    }
}