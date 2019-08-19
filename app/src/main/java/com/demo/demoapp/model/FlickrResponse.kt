package com.demo.demoapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FlickrResponse(val photos: Photos) : Parcelable