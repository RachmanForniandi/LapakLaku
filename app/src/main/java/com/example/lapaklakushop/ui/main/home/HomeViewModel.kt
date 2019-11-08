package com.example.lapaklakushop.ui.main.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lapaklakushop.repo.TransactionRepository
import com.example.lapaklakushop.ui.main.home.model.ImageResponse
import com.example.lapaklakushop.ui.main.home.model.ResponseCategory
import com.example.lapaklakushop.ui.main.home.model.ResponseJenisProduk

class HomeViewModel: ViewModel() {

    var repo= TransactionRepository()

    var img = MutableLiveData<ImageResponse>()

    var isLoading =MutableLiveData<Boolean>()

    var apiError = MutableLiveData<Throwable>()

    var category = MutableLiveData<ResponseCategory>()

    var kindOfProduct = MutableLiveData<ResponseJenisProduk>()


    fun callImgSlide(){

        isLoading.value = true

        repo.forImgSlider({
            img.value = it;
            isLoading.value = false
        },{
            apiError.value = it;
            isLoading.value = false
        })
    }


    fun callCategory(){
        isLoading.value = true

        repo.forCategory({
            category.value = it;
            isLoading.value = false
        },{
            apiError.value = it;
            isLoading.value = false
        })

    }

    fun callKindOfProduct(){

        isLoading.value = true

        repo.forKindOfProduct({
            kindOfProduct.value = it;
            isLoading.value = false
        },{
            apiError.value = it;
            isLoading.value = false
        })
    }



}