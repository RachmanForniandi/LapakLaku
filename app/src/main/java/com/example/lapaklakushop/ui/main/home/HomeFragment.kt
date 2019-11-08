package com.example.lapaklakushop.ui.main.home


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get

import com.example.lapaklakushop.ui.main.home.model.ImageResponse
import com.synnapps.carouselview.ImageListener
import android.R
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.lapaklakushop.BuildConfig
import com.example.lapaklakushop.ui.listProduct.ListProductActivity
import com.example.lapaklakushop.ui.main.home.adapter.CategoryAdapter
import com.example.lapaklakushop.ui.main.home.adapter.KindOfProductAdapter
import com.example.lapaklakushop.ui.main.home.listener.onItemClick
import com.example.lapaklakushop.ui.main.home.listener.onItemClickKindProduct
import com.example.lapaklakushop.ui.main.home.model.DataItem
import com.example.lapaklakushop.ui.main.home.model.ResponseCategory
import com.example.lapaklakushop.ui.main.home.model.ResponseJenisProduk
import kotlinx.android.synthetic.main.fragment_home.*
import org.jetbrains.anko.support.v4.startActivity


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    private var data :List<DataItem?>?= null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(com.example.lapaklakushop.R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = createViewModel()
        viewModel.callImgSlide()
        viewModel.callCategory()
        viewModel.callKindOfProduct()

        imgObserver()
    }

    private fun imgObserver() {
        viewModel.img.observe(this, Observer { showImage(it) })
        viewModel.category.observe(this, Observer { showCategory(it) })
        viewModel.kindOfProduct.observe(this, Observer { showKindOfProduct(it) })
    }

    private fun showKindOfProduct(it: ResponseJenisProduk?) {
        listJenisProduct.adapter = KindOfProductAdapter(it?.jp, object :onItemClickKindProduct{
            override fun onItemClick(name: String?) {
                startActivity<ListProductActivity>("name" to name)
            }

        })
    }

    private fun showCategory(it: ResponseCategory?) {
        listKategori.adapter =CategoryAdapter(it?.kategori,object :onItemClick{
            override fun onItem(id: String) {
                startActivity<ListProductActivity>("id" to id)
            }

        })
    }

    private fun showImage(it: ImageResponse?) {
        data = it?.data
        carouselView.setImageListener(imageListener)
        carouselView.pageCount = data?.size ?:0

    }

    var imageListener: ImageListener = object : ImageListener {
        override fun setImageForPosition(position: Int, imageView: ImageView) {
            //imageView.setImageResource(sampleImages[position])
            context?.let {
                Glide.with(it)
                    .load(BuildConfig.BASE_URL_IMG + data?.get(position)?.produkGambar)
                    .into(imageView)
            }
        }
    }

    private fun createViewModel()=ViewModelProviders.of(this).get(HomeViewModel::class.java)


}
