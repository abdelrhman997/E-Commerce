package com.example.myapplication.domain.repository

import com.example.myapplication.data.model.CRUDResponse
import com.example.myapplication.data.model.Product


interface ProductsRepository {

    suspend fun getProducts(): List<Product>

    suspend fun getCategories(): List<String>


}