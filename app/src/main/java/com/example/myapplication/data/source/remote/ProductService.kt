package com.example.myapplication.data.source.remote


import com.example.myapplication.data.model.Product
import retrofit2.http.GET

interface ProductService {

    @GET("products")
    suspend fun getProducts(): List<Product>

    @GET("products/categories")
    suspend fun getCategories(): List<String>

}