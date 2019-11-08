package com.example.lapaklakushop.ui.login.model


import com.google.gson.annotations.SerializedName

data class User(

	@field:SerializedName("user_status")
	val userStatus: String? = null,

	@field:SerializedName("user_nama")
	val userNama: String? = null,

	@field:SerializedName("user_email")
	val userEmail: String? = null,

	@field:SerializedName("user_password")
	val userPassword: String? = null,

	@field:SerializedName("user_hp")
	val userHp: String? = null,

	@field:SerializedName("user_lat")
	val userLat: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("user_email_verified_at")
	val userEmailVerifiedAt: String? = null,

	@field:SerializedName("user_lng")
	val userLng: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("user_id")
	val userId: String? = null,

	@field:SerializedName("user_level")
	val userLevel: String? = null,

	@field:SerializedName("user_token")
	val userToken: String? = null,

	@field:SerializedName("remember_token")
	val rememberToken: String? = null,

	@field:SerializedName("user_photo")
	val userPhoto: String? = null,

	@field:SerializedName("user_tanggal")
	val userTanggal: String? = null
)