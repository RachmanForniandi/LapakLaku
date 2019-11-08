package com.example.lapaklakushop.ui.main.home.model


import com.google.gson.annotations.SerializedName

data class ImageResponse(

	@field:SerializedName("data")
	val data: List<DataItem?>? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: Int? = null
)