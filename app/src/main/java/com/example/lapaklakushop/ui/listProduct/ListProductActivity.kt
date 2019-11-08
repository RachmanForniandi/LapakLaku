package com.example.lapaklakushop.ui.listProduct

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import com.example.lapaklakushop.R
import com.example.lapaklakushop.ui.listProduct.adapter.ProductAdapter
import com.example.lapaklakushop.ui.listProduct.model.ResponseProduct
import kotlinx.android.synthetic.main.activity_list_product.*
import org.jetbrains.anko.toast

class ListProductActivity : AppCompatActivity() {

    lateinit var viewModel: ProductViewModel
    private var  id: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_product)

        viewModel = ViewModelProviders.of(this).get(ProductViewModel::class.java)

        id = intent.getStringExtra("id")
        viewModel.callDataProduct(id ?:"")

        if (id != null) {
            viewModel.callDataProduct(id ?: "")


        }else{
            var name = intent.getStringExtra("name")

            if (name == "PROMOSI"){
                viewModel.callProductPromotion()
            }else if (name == "POPULER"){
                viewModel.callProductPopular()
            }
        }

        attachObserver()
    }

    private fun attachObserver() {
        viewModel.isLoading.observe(this, Observer { showLoadingProduct(it) })
        viewModel.apiError.observe(this, Observer { showErrorProduct(it) })
        viewModel.productResponse.observe(this, Observer { showResponseProduct(it) })
    }

    private fun showResponseProduct(it: ResponseProduct?) {
        listDataProduct.adapter =ProductAdapter(it?.product)
    }

    private fun showErrorProduct(it: Throwable?) {
        toast(it?.message ?:"")
    }

    private fun showLoadingProduct(show: Boolean?) {
        if (show ?: true)progressProduct.visibility =View.VISIBLE
        else progressProduct.visibility = View.GONE
    }
}
