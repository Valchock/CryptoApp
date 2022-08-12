package com.example.cryptoapp.data.datasources.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exchangeInfo")
data class ExchangeInfoEntity(
    @PrimaryKey
    @ColumnInfo(name = "symbol")
    val symbol: String,

    @ColumnInfo(name = "base_asset")
    val baseAsset: String,

    @ColumnInfo(name = "quote_asset")
    val quoteAsset: String,

    @ColumnInfo(name = "open_price")
    val openPrice: String,

    @ColumnInfo(name = "low_price")
    val lowPrice: String,

    @ColumnInfo(name = "high_price")
    val highPrice: String,

    @ColumnInfo(name = "last_price")
    val lastPrice: String,

    @ColumnInfo(name = "volume")
    val volume: String,

    @ColumnInfo(name = "bid_price")
    val bidPrice: String,

    @ColumnInfo(name = "ask_price")
    val askPrice: String,

    @ColumnInfo(name = "at")
    val at: Long
)
