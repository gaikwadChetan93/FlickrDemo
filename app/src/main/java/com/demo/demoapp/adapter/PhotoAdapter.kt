package com.demo.demoapp.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.demo.demoapp.R
import com.demo.demoapp.event.PhotoClickListener
import com.demo.demoapp.model.Photo
import com.squareup.picasso.Picasso


class PhotoAdapter(private val listdata: List<Photo>, private val photoClickListener: PhotoClickListener) :
    RecyclerView.Adapter<PhotoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.photo_row, parent, false)
        return ViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val photo = listdata[position]
        holder.textView.text = photo.title
        holder.layout.setOnClickListener {
            photoClickListener.onPhotoClicked(photo)
        }
        Picasso
            .get()
            .load(photo.url_l)
            .resize(200, 200)
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.image)

    }


    override fun getItemCount(): Int {
        return listdata.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById<View>(R.id.photoTitle) as TextView
        val image: ImageView = itemView.findViewById<View>(R.id.photo) as ImageView
        val layout: LinearLayout = itemView.findViewById<View>(R.id.photoLayout) as LinearLayout

    }
}  
