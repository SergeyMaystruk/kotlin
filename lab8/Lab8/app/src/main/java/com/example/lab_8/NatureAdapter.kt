package com.example.lab_8

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lab_8.databinding.RecycleViewBinding


class NatureAdapter (private val items: List<Pair<String, String?>>,
                     private val onItemClick: (position: Int) -> Unit):
                    RecyclerView.Adapter<NatureAdapter.NatureHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NatureHolder {
        val binding = RecycleViewBinding.inflate(LayoutInflater.from(parent.context))
        return NatureHolder(binding, onItemClick)
    }

    override fun onBindViewHolder(holder: NatureHolder, position: Int) {
        val nature = items[position]
        holder.bind(nature.first, nature.second)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class NatureHolder(private val binding: RecycleViewBinding,
                       private val onItemClick: (position: Int) -> Unit) :
        RecyclerView.ViewHolder(binding.root) {
            init {
                binding.natureButton.setOnClickListener {
                    onItemClick(adapterPosition)
                }
            }
            fun bind(nature: String, img: String?) {
                Glide.with(binding.imageView)
                    .load(img)
                    .centerCrop()
                    .placeholder(binding.imageView.drawable)
                    .error(R.drawable.ic_launcher_background)
                    .fallback(R.drawable.ic_launcher_foreground)
                    .into(binding.imageView)
                binding.natureButton.text = nature
        }
    }
}