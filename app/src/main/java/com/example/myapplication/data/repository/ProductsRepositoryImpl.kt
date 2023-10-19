package com.example.myapplication.data.repository


import com.example.myapplication.data.model.Product
import com.example.myapplication.domain.datasource.remote.RemoteDataSource
import com.example.myapplication.domain.repository.ProductsRepository
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : ProductsRepository {

    override suspend fun getProducts(): List<Product> {

        return remoteDataSource.getProducts().map {
            with(it) {
                Product(
                    id,title,price,description,category,image,rating
                )
            }
        }
    }

    override suspend fun getCategories() = remoteDataSource.getCategories()



}