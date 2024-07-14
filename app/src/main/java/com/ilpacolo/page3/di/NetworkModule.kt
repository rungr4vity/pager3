package com.ilpacolo.page3.di

import com.ilpacolo.page3.data.RickMortyApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object  NetworkModule {


    private const val BASE_URL = "https://rickandmortyapi.com/api/"


    @Provides
    fun provideApiService(retrofit: Retrofit): RickMortyApiService =
        retrofit.create(RickMortyApiService::class.java)



    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()


    @Provides
    fun providesOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder().build()

}