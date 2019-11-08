package com.example.lapaklakushop.ui.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lapaklakushop.repo.TransactionRepository
import com.example.lapaklakushop.ui.login.model.LoginResponse

class LoginViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    // get repository
    var transactionRepository = TransactionRepository()

    //create live data utk true/false dari progressbar
    var isLoading = MutableLiveData<Boolean>()

    var responseLogin = MutableLiveData<LoginResponse>()

    var apiError = MutableLiveData<Throwable>()

    var isEmpty = MutableLiveData<Boolean>()


    fun login(email:String, password: String){

        if (email.isEmpty()||password.isEmpty()){

            isEmpty.value=true
        }else{
            isLoading.value = true

            isEmpty.value=false

            transactionRepository.login(email,password,{
                responseLogin.value = it
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
