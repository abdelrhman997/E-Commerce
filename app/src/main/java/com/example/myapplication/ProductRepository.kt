package com.example.myapplication

class ProductRepository constructor(private val retrofitService: RetrofitService) {
    suspend fun getAllProducts() = retrofitService.getProducts()
    suspend fun getAllCategories()=retrofitService.getCategories()
}