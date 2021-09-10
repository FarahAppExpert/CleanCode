package com.example.cleancode.presentation.library

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.cleancode.R
import com.example.cleancode.domain.FlowerModel
import org.abego.treelayout.internal.util.java.lang.string.StringUtil


class FlowerAdapter(
    private val flowers: MutableList<FlowerModel> = mutableListOf(),
    private val glide: RequestManager,
    private val itemClickListener: (FlowerModel) -> Unit
) : RecyclerView.Adapter<FlowerAdapter.ViewHolder>() {

  class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val flower_photo: ImageView = view.findViewById(R.id.flower_photo) as ImageView
    val flower_category: TextView = view.findViewById(R.id.flower_category) as TextView
    val flower_instructions: TextView = view.findViewById(R.id.flower_instructions) as TextView
    val flower_price: TextView = view.findViewById(R.id.flower_price) as TextView
    val flower_name: TextView = view.findViewById(R.id.flower_name) as TextView
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    return ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.item_document, parent, false)
    )
  }

  override fun getItemCount() = flowers.size

  override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.run {
    glide.load(flowers[position].productId)
        .error(glide.load(R.drawable.preview_missing))
        .into(holder.flower_photo)
    holder.flower_photo.setImageResource(R.drawable.preview_missing)
    holder.flower_category.text = flowers[position].category
    holder.flower_name.text = flowers[position].name
    holder.flower_price.text = flowers[position].price.toString()
    holder.flower_instructions.text = StringUtil.quote(flowers[position].instructions)
    holder.itemView.setOnClickListener { itemClickListener.invoke(flowers[position]) }
  }

  fun update(newFlower: List<FlowerModel>) {
      flowers.clear()
      flowers.addAll(newFlower)

    notifyDataSetChanged()
  }
}