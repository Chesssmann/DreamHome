package com.uilover.project2122.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.uilover.project2122.Activity.DetailActivity
import com.uilover.project2122.Model.ItemsDomain
import com.uilover.project2122.databinding.ViewholderItemBinding

class ItemsAdapter(private val items: ArrayList<ItemsDomain>) :
    RecyclerView.Adapter<ItemsAdapter.Viewholder>() {
    private lateinit var context: Context

    class Viewholder(val binding: ViewholderItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsAdapter.Viewholder {
        val binding =
            ViewholderItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        context = parent.context
        return Viewholder(binding)
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onBindViewHolder(holder: ItemsAdapter.Viewholder, position: Int) {
        val item = items[position]
        with(holder.binding) {
            titleTxt.text = item.title
            priceTxt.text = "$${item.price}"
            bedTxt.text = item.bed.toString()
            bathTxt.text = item.bath.toString()

            val drawableReousrceId = holder.itemView.resources.getIdentifier(
                item.pickPath, "drawable", holder.itemView.context.packageName
            )

            Glide.with(context)
                .load(drawableReousrceId)
                .into(pic)

            holder.itemView.setOnClickListener {
            val intent=Intent(context,DetailActivity::class.java)
                intent.putExtra("object",item)
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int = items.size
}