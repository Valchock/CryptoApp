package com.example.cryptoapp.data.datasources.remote.service

import com.example.cryptoapp.data.datasources.remote.response.ExchangeInfoResponse
import com.example.cryptoapp.data.datasources.remote.response.ExchangeSymbolView
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CryptoService {

    @GET("/sapi/v1/tickers/24hr")
    suspend fun getExchangeInfo(): Response<ExchangeInfoResponse>

    @GET("/sapi/v1/ticker/24hr")
    suspend fun getSymbolInfo(@Query("symbol") symbol: String): Response<ExchangeSymbolView>
}