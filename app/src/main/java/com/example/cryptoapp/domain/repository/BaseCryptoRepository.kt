package com.example.cryptoapp.domain.repository

import com.example.cryptoapp.presentation.model.ExchangeInfo
import kotlinx.coroutines.flow.Flow

interface BaseCryptoRepository {

    suspend fun syncExchangeInfo()

    suspend fun getExchangeInfoByCurrency(currency : String) : Flow<List<ExchangeInfo>>
}