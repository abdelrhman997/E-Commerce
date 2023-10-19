package com.example.myapplication.domain.datasource.remote

import com.example.myapplication.data.model.Product


interface RemoteDataSource {

    suspend fun getProducts(): List<Product>

    suspend fun getCategories(): List<String>

}