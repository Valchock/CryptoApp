package com.example.cryptoapp.domain.usecases

import com.example.cryptoapp.domain.Result
import com.example.cryptoapp.domain.repository.BaseCryptoRepository
import com.example.cryptoapp.presentation.model.SymbolInfo
import kotlinx.coroutines.flow.Flow

class SymbolInfoUseCase(private val repository: BaseCryptoRepository) {

    suspend operator fun invoke(symbol: String): Flow<Result<SymbolInfo>> {
        return repository.getSymbolInfo(symbol)
    }
}