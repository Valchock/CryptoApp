package com.example.cryptoapp.utils

import com.example.cryptoapp.data.datasources.remote.service.CryptoService
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Utils to build api services using Retrofit object with OKHttpClient.
 */
object RetrofitBuilder {

    private val baseOkHttpClient by lazy { OkHttpClient() }

    @JvmStatic
    val gson by lazy { Gson() }

    /**
     * GsonConverterFactory to deserialize the json response into classes.
     */
    private val gsonConverterFactory by lazy { GsonConverterFactory.create() }

    /**
     * OkHttpClient - Log
     */
    private val okHttpClient by lazy {
        baseOkHttpClient.newBuilder()
            .also {
                it.addInterceptor(
                    HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    }
                )
            }
            .build()
    }

    /**
     *  Singleton instance of [Retrofit]
     */
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.wazirx.com")
            .addConverterFactory(
                gsonConverterFactory
            )
            .client(okHttpClient)
            .build()
    }

    /**
     * API service for crypto
     */
    val cryptoService: CryptoService
        get() = retrofit.create(CryptoService::class.java)

}