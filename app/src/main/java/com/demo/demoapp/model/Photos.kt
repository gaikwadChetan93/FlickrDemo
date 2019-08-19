package com.demo.demoapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Photos(val photo: Array<Photo>, val total: String) : Parcelable