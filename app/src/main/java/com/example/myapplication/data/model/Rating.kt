package com.example.myapplication.data.model

import com.google.gson.annotations.SerializedName


data class Rating (@SerializedName("rate") var rate: Double? = null, @SerializedName("count") var count: Int?    = null)