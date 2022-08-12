package com.example.cryptoapp.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.cryptoapp.R
import com.example.cryptoapp.presentation.viewModel.CryptoExchangeViewModel

class MainActivity : AppCompatActivity() {


    private lateinit var viewModel: CryptoExchangeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this)[CryptoExchangeViewModel::class.java]
        viewModel.syncExchangeInfo()
    }
}