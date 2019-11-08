package com.example.lapaklakushop.ui.main.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lapaklakushop.BuildConfig
import com.example.lapaklakushop.R
import com.example.lapaklakushop.ui.main.home.listener.onItemClick
import com.example.lapaklakushop.ui.main.home.model.KategoriItem
import kotlinx.android.synthetic.main.item_category.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class CategoryAdapter(var dataCategory:List<KategoriItem?>?,val itemClick: onItemClick):RecyclerView.Adapter<CategoryAdapter.CategoryHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapter.CategoryHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category,parent,false)
        return CategoryHolder(view)
    }

    override fun getItemCount()= dataCategory?.size ?:0

    override fun onBindViewHolder(holder: CategoryAdapter.CategoryHolder, position: Int) {
        holder.bind(dataCategory?.get(position))
        holder.itemView.onClick {
            itemClick.onItem(dataCategory?.get(position)?.kategoriId?:"")
        }
    }

    class CategoryHolder (itemView:View):RecyclerView.ViewHolder(itemView){
        fun bind(get: KategoriItem?) {
            itemView.txtTitleCategory.text =get?.kategoriNama

            Glide.with(itemView.context)
                .load(BuildConfig.BASE_URL_IMG+get?.foto)
                .into(itemView.imgCategory)
        }

    }
}