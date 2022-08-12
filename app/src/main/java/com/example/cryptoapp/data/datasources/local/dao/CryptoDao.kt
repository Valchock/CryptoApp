package com.example.cryptoapp.data.datasources.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cryptoapp.data.datasources.local.entities.ExchangeInfoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CryptoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExchangeInfo(exchangeInfoEntity: List<ExchangeInfoEntity>)

    @Query("SELECT * FROM exchangeInfo WHERE quote_asset = :currency")
    fun getExchangeInfoByCurrency(currency: String): Flow<List<ExchangeInfoEntity>>
}