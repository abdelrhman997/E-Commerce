package com.example.myapplication.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.ProductListAdapter
import com.example.myapplication.ProductRepository
import com.example.myapplication.R
import com.example.myapplication.RetrofitService
import com.example.myapplication.databinding.FragmentHomeBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    private val TAG = "HomeFragment"
    lateinit var viewModel: HomeViewModel
    private val retrofitService = RetrofitService.getInstance()
    val adapter = ProductListAdapter()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding=DataBindingUtil.inflate(inflater, R.layout.fragment_home,container,false)

        viewModel = ViewModelProvider(
            this,
            HomeViewModelFactory(ProductRepository(retrofitService))
        )[HomeViewModel::class.java]
        val gridLayoutManager = GridLayoutManager(context,2)
        binding.recyclerview.layoutManager = gridLayoutManager
        binding.recyclerview.adapter = adapter
        viewModel.ProductList.observe(viewLifecycleOwner, Observer {
            Log.d(TAG, "onCreate: $it")
            adapter.setProductsList(it)
        })
        viewModel.errorMessage.observe(viewLifecycleOwner) {
        }
        lifecycleScope.launch {
            viewModel.getAllProducts()
            }

//    }
//        val recyclerView=binding.productsRecyclerView
//        val adapter= ProductListAdapter(productList)
//        recyclerView.setHasFixedSize(true)
//
//        val GridLayoutManager = GridLayoutManager(context,2)
//        recyclerView.layoutManager = GridLayoutManager
//        recyclerView.adapter = adapter
        return binding.root
    }


}







