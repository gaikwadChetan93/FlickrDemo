package com.demo.demoapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.demo.demoapp.model.Photo
import com.squareup.picasso.Picasso

class PhotoDetailActivity : AppCompatActivity() {

    lateinit var image: ImageView
    lateinit var imgTitle: TextView

    private lateinit var photo:Photo
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_detail)

        image = findViewById(R.id.photo)
        imgTitle = findViewById(R.id.title)

        photo = intent.getParcelableExtra("data")
        imgTitle.text = photo.title

        Picasso
            .get()
            .load(photo.url_l)
            .resize(500, 500)
            .placeholder(R.drawable.ic_launcher_background)
            .into(image)
    }
}
