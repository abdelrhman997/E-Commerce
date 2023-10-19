package com.example.myapplication.di


import com.example.myapplication.data.repository.ProductsRepositoryImpl
import com.example.myapplication.domain.datasource.remote.RemoteDataSource
import com.example.myapplication.domain.repository.ProductsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//@Module
//@InstallIn(SingletonComponent::class)
object RepositoryModule {

//    @Provides
//    @Singleton
    fun provideProductsRepository(
        remoteDataSource: RemoteDataSource): ProductsRepository = ProductsRepositoryImpl(remoteDataSource)
}