package com.example.cryptoapp.presentation.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.cryptoapp.data.CryptoRepository
import com.example.cryptoapp.domain.usecases.ExchangeInfoUseCase
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CryptoExchangeViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = CryptoRepository(application)
    private val exchangeInfoUseCase = ExchangeInfoUseCase(repository)

    fun syncExchangeInfo() {
        viewModelScope.launch {
            exchangeInfoUseCase()
        }
    }


}