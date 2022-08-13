package com.example.cryptoapp.data.mappers

import com.example.cryptoapp.data.datasources.remote.response.ExchangeSymbolView
import com.example.cryptoapp.presentation.model.SymbolInfo

fun ExchangeSymbolView.toDomainEntity(): SymbolInfo {
    return SymbolInfo(
            symbol = symbol,
            baseAsset = baseAsset,
            quoteAsset = quoteAsset,
            openPrice = openPrice,
            highPrice = highPrice,
            lastPrice = lastPrice,
            lowPrice = lowPrice,
            bidPrice = bidPrice,
            askPrice = askPrice,
            volume = volume,
            at = at
        )
    }
