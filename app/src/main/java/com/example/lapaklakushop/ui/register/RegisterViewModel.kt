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

    var isEmpty = MutableLiveData<Boolean>()

    fun register(name:String, email:String, password: String, noPhone:String){

        if (name.isEmpty()||email.isEmpty()||password.isEmpty()||noPhone.isEmpty()){
            isEmpty.value= true
        }else{

            isLoading.value = true
            isEmpty.value=false

            transactionRepository.register(name,email,password,noPhone,{
                responseRegister.value = it
                isLoading.value =false
            },{
                apiError.value = it
                isLoading.value = false
            })

        }


    }

    override fun onCleared() {
        super.onCleared()

        transactionRepository.onClear()
    }
}
