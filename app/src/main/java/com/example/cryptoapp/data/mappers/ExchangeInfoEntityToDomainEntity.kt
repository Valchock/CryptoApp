package com.example.cryptoapp.data.mappers


import com.example.cryptoapp.data.datasources.local.entities.ExchangeInfoEntity
import com.example.cryptoapp.presentation.model.ExchangeInfo

fun List<ExchangeInfoEntity>.toDomainEntity(): List<ExchangeInfo> {
    return map {
        ExchangeInfo(
            symbol = it.symbol,
            baseAsset = it.baseAsset,
            quoteAsset = it.quoteAsset,
            volume = it.volume,
            bidPrice = it.bidPrice
        )

    }
}