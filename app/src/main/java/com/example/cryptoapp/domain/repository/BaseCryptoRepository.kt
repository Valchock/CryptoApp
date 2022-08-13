package com.example.cryptoapp.domain.repository

import com.example.cryptoapp.domain.Result
import com.example.cryptoapp.presentation.model.ExchangeInfo
import com.example.cryptoapp.presentation.model.SymbolInfo
import kotlinx.coroutines.flow.Flow

interface BaseCryptoRepository {

    suspend fun syncExchangeInfo()

    suspend fun getExchangeInfoByCurrency(currency: String): Flow<List<ExchangeInfo>>

    suspend fun getSymbolInfo(symbol: String): Flow<Result<SymbolInfo>>
}