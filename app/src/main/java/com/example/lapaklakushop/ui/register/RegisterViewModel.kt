package com.example.lapaklakushop.ui.register

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lapaklakushop.repo.TransactionRepository
import com.example.lapaklakushop.ui.register.model.RegisterResponse

class RegisterViewModel : ViewModel() {

    // get repository
    var transactionRepository = TransactionRepository()

    //create live data utk true/false dari progressbar
    var isLoading = MutableLiveData<Boolean>()

    var responseRegister = MutableLiveData<RegisterResponse>()

    var apiError = MutableLiveData<Throwable>()

    fun register(name:String, email:String, password: String, noPhone:String){
        isLoading.value = true
        transactionRepository.register(name,email,password,noPhone,{
            responseRegister.value = it
            isLoading.value =false
        },{
            apiError.value = it
            isLoading.value = false
        })

    }
}
