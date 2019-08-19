package com.demo.demoapp.event

import com.demo.demoapp.model.Photo

interface PhotoClickListener {
    fun onPhotoClicked(photo: Photo)
}