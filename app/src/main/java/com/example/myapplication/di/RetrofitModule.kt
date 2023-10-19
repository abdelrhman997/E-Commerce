package com.example.myapplication.di

import com.example.myapplication.data.model.Product
import com.example.myapplication.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

//@Module
//@InstallIn(SingletonComponent::class)
object RetrofitModule {

//    @Provides
//    @Singleton
    fun provideProductService(): Product = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(Product::class.java)
}