package com.example.cryptoapp.domain.usecases

import com.example.cryptoapp.domain.repository.BaseCryptoRepository

class ExchangeInfoUseCase (private val repository : BaseCryptoRepository) {

    suspend operator fun invoke(){
        repository.syncExchangeInfo()
    }
}