package com.example.lapaklakushop.networkUtils

import com.example.lapaklakushop.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

object ApiClient {


    //configure interceptor
    fun getInterceptor():OkHttpClient{

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        var okHttpClient = OkHttpClient.Builder().addInterceptor(interceptor)
            .build()

        return okHttpClient
    }

    //configure retrofit
    fun useRetrofit():Retrofit{

        var retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(getInterceptor())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        return retrofit
    }

    fun useService() = useRetrofit().create(ApiService::class.java)

    /*fun useService():ApiService{
        return useRetrofit().create(ApiService::class.java)
    }*/

}