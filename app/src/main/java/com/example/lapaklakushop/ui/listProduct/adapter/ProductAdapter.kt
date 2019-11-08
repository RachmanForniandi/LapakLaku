package com.example.lapaklakushop.ui.listProduct.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lapaklakushop.BuildConfig
import com.example.lapaklakushop.R
import com.example.lapaklakushop.ui.listProduct.model.ProductItem
import com.example.lapaklakushop.ui.main.home.adapter.CategoryAdapter
import com.example.lapaklakushop.ui.main.home.model.KategoriItem
import com.example.lapaklakushop.utility.HeroHelper
import kotlinx.android.synthetic.main.item_category.view.*
import kotlinx.android.synthetic.main.item_product.view.*

class ProductAdapter (var dataProduct:List<ProductItem?>?): RecyclerView.Adapter<ProductAdapter.ProductHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.ProductHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product,parent,false)
        return ProductHolder(view)
    }

    override fun getItemCount()=dataProduct?.size ?:0

    override fun onBindViewHolder(holder: ProductAdapter.ProductHolder, position: Int) {
        holder.bind(dataProduct?.get(position))
    }

    class ProductHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        fun bind(get: ProductItem?) {
            itemView.txtProductItemTitle.text =get?.produkNama

            Glide.with(itemView.context)
                .load(BuildConfig.BASE_URL_IMG+get?.produkGambar)
                .into(itemView.imgItemProduct)

            itemView.txtProductItemPrice.text = "Rp " +HeroHelper.toRupiahFormat(get?.produkHarga ?:"")
            itemView.productItemRating.rating = get?.produkRating?.toFloat()?:0f
        }

    }

}