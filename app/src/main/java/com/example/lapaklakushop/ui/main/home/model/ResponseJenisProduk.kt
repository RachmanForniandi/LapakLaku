package com.example.lapaklakushop.ui.main.home.model


import com.google.gson.annotations.SerializedName

data class ResponseJenisProduk(

	@field:SerializedName("jp")
	val jp: List<JpItem?>? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: Int? = null
)