package com.example.cryptoapp.data

import android.content.Context
import com.example.cryptoapp.data.datasources.local.CryptoLocalDataSource
import com.example.cryptoapp.data.datasources.remote.CryptoRemoteDataSource
import com.example.cryptoapp.data.mappers.toDomainEntity
import com.example.cryptoapp.data.mappers.toRoomEntity
import com.example.cryptoapp.domain.Status
import com.example.cryptoapp.domain.repository.BaseCryptoRepository
import com.example.cryptoapp.presentation.model.ExchangeInfo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CryptoRepository(val context: Context) : BaseCryptoRepository {

    val remoteDataSource = CryptoRemoteDataSource()
    val localDataSource = CryptoLocalDataSource(context)

    override suspend fun syncExchangeInfo() {
        val response = remoteDataSource.getExchangeInfo()
        if (response.status == Status.SUCCESS) {
            response.data?.let { localDataSource.insertExchangeInfo(it.toRoomEntity()) }
        }
    }

    override suspend fun getExchangeInfoByCurrency(currency: String) : Flow<List<ExchangeInfo>> {
       return localDataSource.getExchangeInfoByCurrency(currency).map {
            it.toDomainEntity()
        }
    }


}