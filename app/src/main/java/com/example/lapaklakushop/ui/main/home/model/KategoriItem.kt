package com.example.lapaklakushop.ui.main.home.model


import com.google.gson.annotations.SerializedName


data class KategoriItem(

	@field:SerializedName("kategori_id")
	val kategoriId: String? = null,

	@field:SerializedName("foto")
	val foto: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("kategori_status")
	val kategoriStatus: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("kategori_nama")
	val kategoriNama: String? = null
)