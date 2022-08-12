package com.example.cryptoapp.data.datasources.remote.service

import com.example.cryptoapp.data.datasources.remote.response.ExchangeInfoResponse
import retrofit2.Response
import retrofit2.http.GET

interface CryptoService {

    @GET("/sapi/v1/tickers/24hr")
    suspend fun getExchangeInfo(): Response<ExchangeInfoResponse>
}