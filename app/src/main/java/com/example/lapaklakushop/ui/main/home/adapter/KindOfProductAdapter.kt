package com.example.lapaklakushop.ui.main.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lapaklakushop.BuildConfig
import com.example.lapaklakushop.R
import com.example.lapaklakushop.ui.main.home.listener.onItemClickKindProduct
import com.example.lapaklakushop.ui.main.home.model.JpItem
import com.example.lapaklakushop.ui.main.home.model.KategoriItem
import kotlinx.android.synthetic.main.item_category.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class KindOfProductAdapter (var dataCategory:List<JpItem?>?,var itemClick: onItemClickKindProduct): RecyclerView.Adapter<KindOfProductAdapter.KindOfProductHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KindOfProductHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category,parent,false)
        return KindOfProductHolder(view)
    }

    override fun getItemCount()= dataCategory?.size ?:0

    override fun onBindViewHolder(holder: KindOfProductHolder, position: Int) {
        holder.bind(dataCategory?.get(position))

        holder.itemView.onClick {
            itemClick.onItemClick(dataCategory?.get(position)?.jpNama)
        }
    }


    class KindOfProductHolder (itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(get: JpItem?) {
            itemView.txtTitleCategory.text =get?.jpNama

            Glide.with(itemView.context)
                .load(BuildConfig.BASE_URL_IMG+get?.jpGambar)
                .into(itemView.imgCategory)
        }

    }
}