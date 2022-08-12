package com.example.cryptoapp.data.datasources.local

import android.content.Context
import com.example.cryptoapp.data.datasources.local.entities.ExchangeInfoEntity

class CryptoLocalDataSource(val context: Context) {

    private val database = CryptoDataBase.getDatabase(context)
    private val cryptoDao = database.cryptoDao()

    suspend fun insertExchangeInfo(exchangeInfoEntity: List<ExchangeInfoEntity>) {
         cryptoDao.insertExchangeInfo(exchangeInfoEntity)
    }

}