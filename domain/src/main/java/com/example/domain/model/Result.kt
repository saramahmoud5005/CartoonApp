package com.example.domain.model

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parceler
import kotlinx.parcelize.Parcelize
import java.util.ArrayList
//import kotlinx.parcelize.Parcelize

@Parcelize
data class Result(
    val created: String,
    val episode: ArrayList<String>?,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
):Parcelable