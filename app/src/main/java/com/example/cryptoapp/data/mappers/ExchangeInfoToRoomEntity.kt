package com.example.cryptoapp.data.mappers

import com.example.cryptoapp.data.datasources.local.entities.ExchangeInfoEntity
import com.example.cryptoapp.data.datasources.remote.response.ExchangeInfoResponse

fun ExchangeInfoResponse.toRoomEntity(): List<ExchangeInfoEntity> {
    return map {
        ExchangeInfoEntity(
            symbol = it.symbol,
            baseAsset = it.baseAsset,
            quoteAsset = it.quoteAsset,
            openPrice = it.openPrice,
            lowPrice = it.lowPrice,
            highPrice = it.highPrice,
            lastPrice = it.lastPrice,
            volume = it.volume,
            bidPrice = it.bidPrice,
            askPrice = it.askPrice,
            at = it.at
        )
    }

}