package com.example.lapaklakushop.ui.listProduct.model


import com.google.gson.annotations.SerializedName


data class ResponseProduct(

    @field:SerializedName("produk")
	val product: List<ProductItem?>? = null,

    @field:SerializedName("message")
	val message: String? = null,

    @field:SerializedName("status")
	val status: Int? = null
)