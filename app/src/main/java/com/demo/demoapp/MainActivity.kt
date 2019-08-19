package com.demo.demoapp

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.demo.demoapp.adapter.PhotoAdapter
import com.demo.demoapp.event.PhotoClickListener
import com.demo.demoapp.model.Photo
import com.demo.demoapp.viewmodel.MyViewModel


class MainActivity : AppCompatActivity(), PhotoClickListener {

    lateinit var username: ImageView
    lateinit var photoListView: RecyclerView
    lateinit var txtTag: TextView
    lateinit var model: MyViewModel
    private val searchAction = 23

    var photoList: List<Photo> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        username = findViewById(R.id.imgSearch)
        txtTag = findViewById(R.id.txtTag)
        photoListView = findViewById(R.id.photoList)

        username.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            startActivityForResult(intent, searchAction)
        }

        setAdapter()

        model = ViewModelProviders.of(this).get(MyViewModel::class.java)
        val list: LiveData<List<Photo>> = model.getUsers()
        list.observe(this, Observer<List<Photo>> {
            Log.d("bdjs", "Inside sub")
            photoList = it ?: listOf()
            setAdapter()
        })


    }

    private fun setAdapter() {
        val adapter = PhotoAdapter(photoList, this)
        photoListView.setHasFixedSize(true)
        photoListView.layoutManager = LinearLayoutManager(this)
        photoListView.adapter = adapter
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == searchAction) {
            val message = data?.getStringExtra("MESSAGE")
            txtTag.text = message
            if (message?.isNotEmpty() ?: "".isNotEmpty()) {
                model.getPhotosByTag(message ?: "")
            }
        }
    }

    override fun onPhotoClicked(photo: Photo) {
        val intent = Intent(this, PhotoDetailActivity::class.java)
        intent.putExtra("data", photo)
        startActivity(intent)
    }
}
