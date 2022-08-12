package com.example.cryptoapp.data.datasources.remote

import com.example.cryptoapp.data.datasources.remote.response.ExchangeInfoResponse
import com.example.cryptoapp.utils.RetrofitBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import com.example.cryptoapp.domain.Result

class CryptoRemoteDataSource {

    suspend fun getExchangeInfo(): Result<ExchangeInfoResponse> {
        return apiCallResponse {
            RetrofitBuilder.cryptoService.getExchangeInfo()
        }
    }
}

suspend inline fun <ResultType> apiCallResponse(crossinline block: suspend () -> Response<ResultType>): Result<ResultType> {
    return try {
        withContext(Dispatchers.IO) {
            val response = block()
            if (response.isSuccessful) {
                @Suppress("UNCHECKED_CAST")
                Result.Success(response.body() as ResultType)
            } else {
                Result.Error(response.errorBody()?.string().orEmpty(), null)
            }
        }
    } catch (throwable: Throwable) {
        return Result.Error(throwable.message.orEmpty(), null)
    }
}