package com.demo.demoapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Photo(var url_l: String?, var id: String, var title: String, val url_h: String?) :
    Parcelable