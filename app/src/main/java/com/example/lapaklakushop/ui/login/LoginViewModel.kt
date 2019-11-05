package com.example.lapaklakushop.ui.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lapaklakushop.repo.TransactionRepository
import com.example.lapaklakushop.ui.login.model.LoginResponse
import com.example.lapaklakushop.ui.register.model.RegisterResponse

class LoginViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    // get repository
    var transactionRepository = TransactionRepository()

    //create live data utk true/false dari progressbar
    var isLoading = MutableLiveData<Boolean>()

    var responseLogin = MutableLiveData<LoginResponse>()

    var apiError = MutableLiveData<Throwable>()


    fun login(email:String, password: String){
        isLoading.value = true
        transactionRepository.login(email,password,{
            responseLogin.value = it
            isLoading.value =false
        },{
            apiError.value = it
            isLoading.value = false
        })

    }

    override fun onCleared() {
        super.onCleared()

        transactionRepository.onClear()
    }

}
