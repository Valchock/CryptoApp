package com.example.cryptoapp.presentation.viewModel

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import com.example.cryptoapp.data.CryptoRepository
import com.example.cryptoapp.domain.usecases.ExchangeInfoUseCase
import androidx.lifecycle.viewModelScope
import com.example.cryptoapp.domain.Result
import com.example.cryptoapp.domain.Status
import com.example.cryptoapp.domain.usecases.GetExchangeInfoByCurrency
import com.example.cryptoapp.domain.usecases.SymbolInfoUseCase
import com.example.cryptoapp.presentation.model.ExchangeInfo
import com.example.cryptoapp.presentation.model.SymbolState
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class CryptoExchangeViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = CryptoRepository(application)
    private val exchangeInfoUseCase = ExchangeInfoUseCase(repository)
    private val getExchangeInfoByCurrency = GetExchangeInfoByCurrency(repository)
    private val getSymbolInfo = SymbolInfoUseCase(repository)

    private val _inrExchangeInfo: MutableState<List<ExchangeInfo>> =
        mutableStateOf(listOf())
    val inrExchangeInfo: State<List<ExchangeInfo>> = _inrExchangeInfo

    private val _usdtExchangeInfo: MutableState<List<ExchangeInfo>> =
        mutableStateOf(listOf())
    val usdtExchangeInfo: State<List<ExchangeInfo>> = _usdtExchangeInfo

    private val _wrxExchangeInfo: MutableState<List<ExchangeInfo>> =
        mutableStateOf(listOf())
    val wrxExchangeInfo: State<List<ExchangeInfo>> = _wrxExchangeInfo

    private val _btcExchangeInfo: MutableState<List<ExchangeInfo>> =
        mutableStateOf(listOf())
    val btcExchangeInfo: State<List<ExchangeInfo>> = _btcExchangeInfo

    private val _symbolInfo: MutableState<SymbolState> =
        mutableStateOf(SymbolState())
    val symbolInfo: State<SymbolState> = _symbolInfo

    val isRefreshing = mutableStateOf(false)

    fun syncExchangeInfo() {
        viewModelScope.launch {
            exchangeInfoUseCase()
            isRefreshing.value = false
        }
    }

    fun getINRExchangeInfo() {
        viewModelScope.launch {
            getExchangeInfoByCurrency("inr").collect { inrExchangeInfoList ->
                _inrExchangeInfo.value = inrExchangeInfoList
            }
        }
    }

    fun getUSDTExchangeInfo() {
        viewModelScope.launch {
            getExchangeInfoByCurrency("usdt").collect { usdtExchangeInfoList ->
                _usdtExchangeInfo.value = usdtExchangeInfoList
            }
        }
    }

    fun getWRXExchangeInfo() {
        viewModelScope.launch {
            getExchangeInfoByCurrency("wrx").collect { wrxExchangeInfoList ->
                _wrxExchangeInfo.value = wrxExchangeInfoList
            }
        }
    }

    fun getBTCExchangeInfo() {
        viewModelScope.launch {
            getExchangeInfoByCurrency("btc").collect { btcExchangeInfoList ->
                _btcExchangeInfo.value = btcExchangeInfoList
            }
        }
    }

    fun getSymbolDetails(symbol: String) {
        viewModelScope.launch {
            getSymbolInfo(symbol).collect {
                when (it.status) {
                    Status.SUCCESS -> {
                        _symbolInfo.value = SymbolState(symbolInfo = it.data)
                    }
                    Status.ERROR -> {
                        _symbolInfo.value = SymbolState(error = it.message!!)
                    }
                    Status.LOADING -> {
                        _symbolInfo.value = SymbolState(isLoading = true)
                    }
                }
            }
        }
    }


}