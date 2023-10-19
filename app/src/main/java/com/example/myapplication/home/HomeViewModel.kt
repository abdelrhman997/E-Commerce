package com.example.myapplication.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.ProductRepository
import com.example.myapplication.data.model.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel constructor(private val repository: ProductRepository)  : ViewModel() {

    val ProductList = MutableLiveData<List<Product>>()
    val CategoriesList = MutableLiveData<List<String>>()
    val errorMessage = MutableLiveData<String>()

    suspend fun getAllProducts() {
        val response = repository.getAllProducts()
        response.enqueue(object : Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                ProductList.postValue(response.body())
            }
            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
    suspend fun getAllCategories() {
        val response = repository.getAllCategories()
        response.enqueue(object : Callback<List<String>> {
            override fun onResponse(call: Call<List<String>>, response: Response<List<String>>) {
                CategoriesList.postValue(response.body())
            }
            override fun onFailure(call: Call<List<String>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}