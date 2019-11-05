package com.example.lapaklakushop.repo

import android.database.DatabaseErrorHandler
import android.provider.ContactsContract
import com.example.lapaklakushop.networkUtils.ApiClient
import com.example.lapaklakushop.ui.register.model.RegisterResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.logging.Handler

class TransactionRepository {

    private var api = ApiClient.useService()
    private var compositeDisposable = CompositeDisposable()

    fun register(name:String, email: String,
                 password:String,noPhone:String,
                 responseHandler: (RegisterResponse)->Unit,
                 errorHandler: (Throwable)->Unit){

        compositeDisposable.add(
            api.registerCommand(name,email,password,noPhone)
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