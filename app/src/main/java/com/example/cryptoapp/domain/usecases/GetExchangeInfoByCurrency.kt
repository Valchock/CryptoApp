package com.example.cryptoapp.domain.usecases

import com.example.cryptoapp.domain.repository.BaseCryptoRepository
import com.example.cryptoapp.presentation.model.ExchangeInfo
import kotlinx.coroutines.flow.Flow

class GetExchangeInfoByCurrency(private val repository: BaseCryptoRepository) {

    suspend operator fun invoke(currency: String): Flow<List<ExchangeInfo>> {
        return repository.getExchangeInfoByCurrency(currency)
    }
}