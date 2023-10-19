package com.example.myapplication.data.source.remote


import com.example.myapplication.data.model.Product
import com.example.myapplication.domain.datasource.remote.RemoteDataSource
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val productService: ProductService
) : RemoteDataSource {

    override suspend fun getProducts(): List<Product> =
        productService.getProducts()

    override suspend fun getCategories(): List<String> =
        productService.getCategories()


}