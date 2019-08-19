package com.demo.demoapp.service;

import com.demo.demoapp.model.FlickrResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FlickrAPI {

    @GET("rest/?format=json&" +
            "method=flickr.photos.search&" +
            "api_key=6bf318919bbbc455f3573d18798a58e3&" +
            "extras=url_l,url_h&nojsoncallback=1")
    Call<FlickrResponse> getPhotos(@Query("tags") String tags);

}