package ru.bogdan.testtaskvodovoz.presenter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.bogdan.testtaskvodovoz.databinding.ItemPhotoBinding

class PhotoAdapter() : RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {
    var photos: List<String> = listOf()
    override fun onBindViewHolder(p0: PhotoViewHolder, p1: Int) {
        val photo = photos[p1]
        p0.bind(photo)
        
    }
    
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): PhotoViewHolder {
        val inflater = LayoutInflater.from(p0.context)
        val binding = ItemPhotoBinding.inflate(inflater, p0, false)
        return PhotoViewHolder(binding)
    }
    
    override fun getItemCount(): Int {
        return photos.size
    }
    
    inner class PhotoViewHolder(private val binding: ItemPhotoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(photo: String) {
            with(binding) {
                Glide.with(root)
                    .load(photo)
                    .centerInside()
                    .into(image)
            }
        }
    }
}