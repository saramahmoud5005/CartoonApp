package com.example.cartoonapp.di

import android.icu.util.TimeUnit
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.cartoonapp.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okio.Timeout
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.Duration
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @RequiresApi(Build.VERSION_CODES.O)
    @Provides
    @Singleton
    fun provideOkHttp():OkHttpClient{
        return OkHttpClient.Builder()
            .readTimeout(20,java.util.concurrent.TimeUnit.SECONDS)
            .callTimeout(20,java.util.concurrent.TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient):Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit):ApiService{
        return retrofit.create(ApiService::class.java)
    }
}