package com.example.cryptoapp.data

import android.content.Context
import com.example.cryptoapp.data.datasources.local.CryptoLocalDataSource
import com.example.cryptoapp.data.datasources.remote.CryptoRemoteDataSource
import com.example.cryptoapp.data.mappers.toRoomEntity
import com.example.cryptoapp.domain.Status
import com.example.cryptoapp.domain.repository.BaseCryptoRepository

class CryptoRepository(val context: Context) : BaseCryptoRepository {

    val remoteDataSource = CryptoRemoteDataSource()
    val localDataSource = CryptoLocalDataSource(context)

    override suspend fun syncExchangeInfo() {
        val response = remoteDataSource.getExchangeInfo()
        if (response.status == Status.SUCCESS) {
            response.data?.let { localDataSource.insertExchangeInfo(it.toRoomEntity()) }
        }
    }
}