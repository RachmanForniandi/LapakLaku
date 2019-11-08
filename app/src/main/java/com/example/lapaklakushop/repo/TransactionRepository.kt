package com.example.lapaklakushop.repo

import com.example.lapaklakushop.networkUtils.ApiClient
import com.example.lapaklakushop.ui.listProduct.model.ResponseProduct
import com.example.lapaklakushop.ui.login.model.LoginResponse
import com.example.lapaklakushop.ui.main.home.model.ImageResponse
import com.example.lapaklakushop.ui.main.home.model.ResponseCategory
import com.example.lapaklakushop.ui.main.home.model.ResponseJenisProduk
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

    fun forImgSlider(responseHandler: (ImageResponse)->Unit,errorHandler: (Throwable) -> Unit){
        compositeDisposable.add(
            api.showImageSlider()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    responseHandler(it)
                },{
                    errorHandler(it)
                })
        )
    }

    fun forCategory(responseHandler: (ResponseCategory) -> Unit,errorHandler: (Throwable) -> Unit){
        compositeDisposable.add(
            api.getCategory()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({responseHandler(it)},{errorHandler(it)})
        )
    }

    fun forKindOfProduct(responseHandler: (ResponseJenisProduk) -> Unit,errorHandler: (Throwable) -> Unit){
        compositeDisposable.add(
            api.getKindOfProduct()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({responseHandler(it)},{errorHandler(it)})
        )
    }

    fun forReceivedProduct(idCategory:String,responseHandler: (ResponseProduct) -> Unit,errorHandler: (Throwable) -> Unit){
        compositeDisposable.add(
            api.getDataProduct(idCategory)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({responseHandler(it)},{errorHandler(it)})
        )
    }

    fun forPromotion(responseHandler: (ResponseProduct) -> Unit,errorHandler: (Throwable) -> Unit){
        compositeDisposable.add(
            api.getPromotion()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({responseHandler(it)},{errorHandler(it)})
        )
    }

    fun forPopular(responseHandler: (ResponseProduct) -> Unit,errorHandler: (Throwable) -> Unit){
        compositeDisposable.add(
            api.getPopularItem()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({responseHandler(it)},{errorHandler(it)})
        )
    }





    fun onClear(){
        compositeDisposable.clear()
    }
}