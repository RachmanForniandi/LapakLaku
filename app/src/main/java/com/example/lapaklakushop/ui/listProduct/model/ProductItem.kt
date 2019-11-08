package com.example.lapaklakushop.ui.listProduct.model


import com.google.gson.annotations.SerializedName


data class ProductItem(

	@field:SerializedName("produk_kategori")
	val produkKategori: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("produk_harga")
	val produkHarga: String? = null,

	@field:SerializedName("produk_stok")
	val produkStok: String? = null,

	@field:SerializedName("produk_status")
	val produkStatus: String? = null,

	@field:SerializedName("produk_growback")
	val produkGrowback: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("produk_tanggal")
	val produkTanggal: String? = null,

	@field:SerializedName("is_promote")
	val isPromote: String? = null,

	@field:SerializedName("produk_nama")
	val produkNama: String? = null,

	@field:SerializedName("produk_gambar")
	val produkGambar: String? = null,

	@field:SerializedName("produk_id")
	val produkId: String? = null,

	@field:SerializedName("produk_rating")
	val produkRating: String? = null,

	@field:SerializedName("is_approve")
	val isApprove: String? = null
)