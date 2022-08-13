package com.example.cryptoapp.data

import android.content.Context
import com.example.cryptoapp.R
import com.example.cryptoapp.data.datasources.local.CryptoLocalDataSource
import com.example.cryptoapp.data.datasources.remote.CryptoRemoteDataSource
import com.example.cryptoapp.data.datasources.remote.response.ExchangeSymbolView
import com.example.cryptoapp.data.mappers.toDomainEntity
import com.example.cryptoapp.data.mappers.toRoomEntity
import com.example.cryptoapp.domain.Result
import com.example.cryptoapp.domain.Status
import com.example.cryptoapp.domain.repository.BaseCryptoRepository
import com.example.cryptoapp.presentation.model.ExchangeInfo
import com.example.cryptoapp.presentation.model.SymbolInfo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
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

    override suspend fun getExchangeInfoByCurrency(currency: String): Flow<List<ExchangeInfo>> {
        return localDataSource.getExchangeInfoByCurrency(currency).map {
            it.toDomainEntity()
        }
    }

    override suspend fun getSymbolInfo(symbol: String): Flow<Result<SymbolInfo>> {
        return flow {
            emit(Result.Loading<SymbolInfo>())
            val response = remoteDataSource.getSymbolInfo(symbol)
            if (response.status == Status.SUCCESS) {
                var data: SymbolInfo? = null
                response.data?.let {
                    data = it.toDomainEntity()
                }
                emit(Result.Success(data))
            } else {
                emit(Result.Error<SymbolInfo>(context.resources.getString(R.string.symbol_info_error)))
            }
        }
    }


}