package com.example.cryptoapp.presentation.model

data class ExchangeInfo(
    val symbol: String,

    val baseAsset: String,

    val quoteAsset: String,

    val volume: String,

    val bidPrice: String
)
