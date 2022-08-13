package com.example.cryptoapp.presentation.model

data class SymbolInfo(
    val symbol: String,
    val baseAsset: String,
    val quoteAsset: String,
    val openPrice: String,
    val highPrice: String,
    val lastPrice: String,
    val lowPrice: String,
    val bidPrice: String,
    val askPrice: String,
    val volume: String,
    val at: Long
)
