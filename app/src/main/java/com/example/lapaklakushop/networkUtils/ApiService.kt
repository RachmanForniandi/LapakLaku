package com.example.lapaklakushop.networkUtils

import com.example.lapaklakushop.ui.register.model.RegisterResponse
import io.reactivex.Single
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST("registerCustomer")
    fun registerCommand(@Field("nama")nama:String,
                        @Field("email")email:String,
                        @Field("hp")hp:String,
                        @Field("password")password:String):Single<RegisterResponse>
}