package com.example.cryptoapp.presentation.viewModel

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import com.example.cryptoapp.data.CryptoRepository
import com.example.cryptoapp.domain.usecases.ExchangeInfoUseCase
import androidx.lifecycle.viewModelScope
import com.example.cryptoapp.domain.usecases.GetExchangeInfoByCurrency
import com.example.cryptoapp.presentation.model.ExchangeInfo
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class CryptoExchangeViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = CryptoRepository(application)
    private val exchangeInfoUseCase = ExchangeInfoUseCase(repository)
    private val getExchangeInfoByCurrency = GetExchangeInfoByCurrency(repository)

    private val _exchangeInfo: MutableState<List<ExchangeInfo>> =
        mutableStateOf(listOf())
    val exchangeInfo: State<List<ExchangeInfo>> = _exchangeInfo

    fun syncExchangeInfo() {
        viewModelScope.launch {
            exchangeInfoUseCase()
        }
    }

    fun getINRExchangeInfo() {
        viewModelScope.launch {
            getExchangeInfoByCurrency("inr").collect { inrExchangeInfoList ->
                _exchangeInfo.value = inrExchangeInfoList
            }
        }
    }

    fun getUSDTExchangeInfo() {
        viewModelScope.launch {
            getExchangeInfoByCurrency("usdt").collect { usdtExchangeInfoList ->
                _exchangeInfo.value = usdtExchangeInfoList
            }
        }
    }

    fun getWRXExchangeInfo() {
        viewModelScope.launch {
            getExchangeInfoByCurrency("wrx").collect { wrxExchangeInfoList ->
                _exchangeInfo.value = wrxExchangeInfoList
            }
        }
    }

    fun getBTCExchangeInfo() {
        viewModelScope.launch {
            getExchangeInfoByCurrency("btc").collect { btcExchangeInfoList ->
                _exchangeInfo.value = btcExchangeInfoList
            }
        }
    }


}