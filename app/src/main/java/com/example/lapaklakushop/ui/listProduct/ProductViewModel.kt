package com.example.lapaklakushop.ui.listProduct

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lapaklakushop.repo.TransactionRepository
import com.example.lapaklakushop.ui.listProduct.model.ResponseProduct

class ProductViewModel : ViewModel() {

    var repo = TransactionRepository()
    var productResponse = MutableLiveData<ResponseProduct>()
    var apiError = MutableLiveData<Throwable>()
    var isLoading = MutableLiveData<Boolean>()

    fun callDataProduct(id: String){

        isLoading.value = true
        repo.forReceivedProduct(id,{
            productResponse.value = it;
            isLoading.value = false
        },{
            apiError.value = it;
            isLoading.value = false
        })
    }

    fun callProductPromotion(){

        isLoading.value = true
        repo.forPromotion({
            productResponse.value = it;
            isLoading.value = false
        },{
            apiError.value = it;
            isLoading.value = false
        })
    }

    fun callProductPopular(){
        isLoading.value = true
        repo.forPopular({
            productResponse.value = it;
            isLoading.value = false
        },{
            apiError.value = it;
            isLoading.value = false
        })
    }


}