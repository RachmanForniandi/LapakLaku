package com.example.lapaklakushop.ui.main.home.model


import com.google.gson.annotations.SerializedName
data class ResponseCategory(

	@field:SerializedName("kategori")
	val kategori: List<KategoriItem?>? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: Int? = null
)