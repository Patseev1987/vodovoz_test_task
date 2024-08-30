package ru.bogdan.testtaskvodovoz.presenter

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.bogdan.testtaskvodovoz.R
import ru.bogdan.testtaskvodovoz.databinding.FragmentPhotosBinding
import ru.bogdan.testtaskvodovoz.presenter.adapter.PhotoAdapter


class PhotosFragment : Fragment(R.layout.fragment_photos) {
    private val binding by viewBinding(FragmentPhotosBinding::bind)
    private lateinit var photos: List<String>
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseArgs()
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = PhotoAdapter()
        adapter.photos = photos
        binding.rcPhotos.adapter = adapter
    }
    
    private fun parseArgs() {
        photos = requireArguments().getStringArray(PHOTOS)?.toList() ?: listOf()
    }
    
    companion object {
        const val PHOTOS = "photos"
        
        fun getFragment(photos: List<String>) = PhotosFragment().apply {
            arguments = Bundle().apply {
                putStringArray(PHOTOS, photos.toTypedArray())
            }
        }
    }
}