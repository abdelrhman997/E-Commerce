package com.example.myapplication.di


import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import com.example.myapplication.data.source.remote.ProductService
import com.example.myapplication.data.source.remote.RemoteDataSourceImpl
import com.example.myapplication.domain.datasource.remote.RemoteDataSource

//@Module
//@InstallIn(SingletonComponent::class)
object DataSourceModule {

//    @Provides
//    @Singleton
    fun provideRemoteDataSource(
        productService: ProductService
    ): RemoteDataSource = RemoteDataSourceImpl(productService)



}