package com.demo.demoapp.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.demo.demoapp.model.FlickrResponse
import com.demo.demoapp.model.Photo
import com.demo.demoapp.service.FlickrAPI
import com.demo.demoapp.service.FlickrService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyViewModel : ViewModel() {
    private val photos: MutableLiveData<List<Photo>> = MutableLiveData()

    private val retrofit: Retrofit
    init {
        retrofit = Retrofit.Builder()
            .baseUrl("https://api.flickr.com/services/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(getClient())
            .build()
    }

    fun getUsers(): LiveData<List<Photo>> {
        return photos
    }

    fun getPhotosByTag(tag: String){
        var photoList: List<Photo>
        val flickrService = retrofit.create(FlickrAPI::class.java)
        flickrService.getPhotos(tag).enqueue(object : Callback<FlickrResponse> {
            override fun onFailure(call: Call<FlickrResponse>, t: Throwable) {
                Log.d("error", t.message)
            }

            override fun onResponse(call: Call<FlickrResponse>, response: Response<FlickrResponse>) {
                Log.d("sdsd", response.body().toString())
                val myPojo: FlickrResponse? = response.body()
                Log.d("total", myPojo?.photos?.total)
                photoList = myPojo?.photos?.photo?.toList() ?: emptyList()
                photos.value = photoList
            }

        })

    }

    private fun getClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    }
}