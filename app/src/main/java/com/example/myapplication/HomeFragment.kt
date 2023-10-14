package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Data.ProductModel
import com.example.myapplication.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    companion object{
        val productList = ArrayList<ProductModel>()
    }
    lateinit var binding:FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)

        productList.add(ProductModel("test",R.drawable.ecommerce_logo,10,100,""))
        productList.add(ProductModel("test1",R.drawable.ecommerce_logo,20,200,""))
        productList.add(ProductModel("test",R.drawable.ecommerce_logo,10,100,""))
        productList.add(ProductModel("test1",R.drawable.ecommerce_logo,20,200,""))
        productList.add(ProductModel("test1",R.drawable.ecommerce_logo,20,200,""))
        productList.add(ProductModel("test1",R.drawable.ecommerce_logo,20,200,""))
        productList.add(ProductModel("test1",R.drawable.ecommerce_logo,20,200,""))
        productList.add(ProductModel("test1",R.drawable.ecommerce_logo,20,200,""))
        productList.add(ProductModel("test1",R.drawable.ecommerce_logo,20,200,""))
        productList.add(ProductModel("test1",R.drawable.ecommerce_logo,20,200,""))
        productList.add(ProductModel("test1",R.drawable.ecommerce_logo,20,200,""))
        productList.add(ProductModel("test1",R.drawable.ecommerce_logo,20,200,""))
        val recyclerView=binding.productsRecyclerView
        val adapter=ProductListAdapter(productList)
        recyclerView.setHasFixedSize(true)
//        val linearLayoutManager = LinearLayoutManager(context)
//        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
//        recyclerView.layoutManager = linearLayoutManager
        val GridLayoutManager = GridLayoutManager(context,2)
        recyclerView.layoutManager = GridLayoutManager
        recyclerView.adapter = adapter
        return binding.root
    }


}







