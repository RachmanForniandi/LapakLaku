package com.example.lapaklakushop.ui.main.home.model


import com.google.gson.annotations.SerializedName

data class JpItem(

	@field:SerializedName("jp_nama")
	val jpNama: String? = null,

	@field:SerializedName("jp_status")
	val jpStatus: String? = null,

	@field:SerializedName("jp_id")
	val jpId: String? = null,

	@field:SerializedName("jp_gambar")
	val jpGambar: String? = null
)