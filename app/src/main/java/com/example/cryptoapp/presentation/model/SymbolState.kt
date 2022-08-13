package com.example.cryptoapp.presentation.model

data class SymbolState(
    val isLoading: Boolean = false,
    val symbolInfo: SymbolInfo? = null,
    val error: String = ""
)