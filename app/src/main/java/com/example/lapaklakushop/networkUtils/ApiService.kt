package com.example.lapaklakushop.networkUtils

import com.example.lapaklakushop.ui.listProduct.model.ResponseProduct
import com.example.lapaklakushop.ui.login.model.LoginResponse
import com.example.lapaklakushop.ui.main.home.model.ImageResponse
import com.example.lapaklakushop.ui.main.home.model.ResponseCategory
import com.example.lapaklakushop.ui.main.home.model.ResponseJenisProduk
import com.example.lapaklakushop.ui.register.model.RegisterResponse
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST("registerCustomer")
    fun registerCommand(@Field("nama")nama:String,
                        @Field("email")email:String,
                        @Field("hp")hp:String,
                        @Field("password")password:String):Single<RegisterResponse>

    @FormUrlEncoded
    @POST("loginCustomer")
    fun loginCommand(@Field("email")email:String,
                     @Field("password")password:String):Single<LoginResponse>

    @GET("gambar_slider")
    fun showImageSlider():Observable<ImageResponse>

    @GET("getKategori")
    fun getCategory():Observable<ResponseCategory>

    @GET("getJenisProduk")
    fun getKindOfProduct():Observable<ResponseJenisProduk>

    @FormUrlEncoded
    @POST("produkPerKategori")
    fun getDataProduct(@Field("id")id:String):Observable<ResponseProduct>

    @GET("promosi")
    fun getPromotion():Observable<ResponseProduct>

    @GET("populer")
    fun getPopularItem():Observable<ResponseProduct>




}