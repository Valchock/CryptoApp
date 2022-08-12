package com.example.cryptoapp.data.datasources.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.cryptoapp.data.datasources.local.entities.ExchangeInfoEntity

@Dao
interface CryptoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExchangeInfo(exchangeInfoEntity: List<ExchangeInfoEntity>)
}