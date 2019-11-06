package com.example.lapaklakushop.repo

import com.example.lapaklakushop.networkUtils.ApiClient
import com.example.lapaklakushop.ui.login.model.LoginResponse
import com.example.lapaklakushop.ui.register.model.RegisterResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class TransactionRepository {

    private var api = ApiClient.useService()
    private var compositeDisposable = CompositeDisposable()

    fun register(name:String,
                 email: String,
                 password:String,
                 noPhone:String,
                 responseHandler: (RegisterResponse)->Unit,
                 errorHandler: (Throwable)->Unit){

        compositeDisposable.add(
            api.registerCommand(name,email,noPhone,password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({

                    responseHandler(it)
                },{
                    errorHandler(it)
                })
        )
    }

    fun login(email: String,
              password:String,
              responseHandler: (LoginResponse)->Unit,
              errorHandler: (Throwable)->Unit){

        compositeDisposable.add(
            api.loginCommand(email,password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({

                    responseHandler(it)
                },{
                    errorHandler(it)
                })
        )
    }





    fun onClear(){
        compositeDisposable.clear()
    }
}