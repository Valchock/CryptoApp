package com.example.cryptoapp.domain.repository

interface BaseCryptoRepository {

    suspend fun syncExchangeInfo()
}