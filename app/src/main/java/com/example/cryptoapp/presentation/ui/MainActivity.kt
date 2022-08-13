package com.example.cryptoapp.presentation.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.example.cryptoapp.presentation.viewModel.CryptoExchangeViewModel
import com.example.cryptoapp.utils.*
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {


    private lateinit var viewModel: CryptoExchangeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val symbol = intent.getStringExtra(
            SYMBOL
        )
        val startDestination = intent.getIntExtra(START_DESTINATION, 0).let {
            if (it == 0) {
                DESTINATION_EXCHANGE_INFO
            } else {
                it
            }
        }
        viewModel = ViewModelProvider(this)[CryptoExchangeViewModel::class.java]
        setContent {
            CryptoHome(startDestination, symbol)
        }
    }

    companion object {
        private const val START_DESTINATION = "start_destination"
        const val SYMBOL = "symbol"
        const val DESTINATION_EXCHANGE_INFO = 0
        const val DESTINATION_EXCHANGE_INFO_DETAILS = 1

        fun openExchangeInfoDetails(context: Context, symbol: String) {
            val intent = Intent(context, MainActivity::class.java)
            intent.putExtra(START_DESTINATION, DESTINATION_EXCHANGE_INFO_DETAILS)
            intent.putExtra(SYMBOL, symbol)
            context.startActivity(intent)
        }
    }

    @Composable
    fun CryptoHome(startDestination: Int, symbol: String?) {
        when (startDestination) {
            DESTINATION_EXCHANGE_INFO -> {
                viewModel.syncExchangeInfo()
                viewModel.getINRExchangeInfo()
                viewModel.getBTCExchangeInfo()
                viewModel.getUSDTExchangeInfo()
                viewModel.getWRXExchangeInfo()
                TabLayout()
            }
            DESTINATION_EXCHANGE_INFO_DETAILS -> {
                symbol?.let {
                    viewModel.getSymbolDetails(symbol)
                    ExchangeInfoDetailsComposable(symbol, viewModel)
                }
            }
        }
    }


    @OptIn(ExperimentalPagerApi::class)
    @Composable
    fun TabLayout() {
        val pagerState = rememberPagerState(pageCount = 4)
        Column() {
            Tabs(pagerState = pagerState)
            TabsContent(pagerState = pagerState)
        }
    }

    @OptIn(ExperimentalPagerApi::class)
    @Composable
    fun Tabs(pagerState: PagerState) {
        val list = listOf(
            "INR",
            "USDT",
            "WRX",
            "BTC"
        )
        val scope = rememberCoroutineScope()
        TabRow(
            selectedTabIndex = pagerState.currentPage,
            backgroundColor = LightGray,
            contentColor = Black,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                    height = 2.dp,
                    color = DarkBlue
                )
            }
        ) {
            list.forEachIndexed { index, _ ->
                Tab(
                    text = {
                        Text(
                            list[index],
                            color = if (pagerState.currentPage == index) Blue else Black
                        )
                    },
                    selected = pagerState.currentPage == index,
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    }
                )
            }
        }
    }

    @ExperimentalPagerApi
    @Composable
    fun TabsContent(pagerState: PagerState) {
        val context = LocalContext.current
        HorizontalPager(state = pagerState) { page ->
            when (page) {
                0 -> ExchangeInfoComposable(viewModel.inrExchangeInfo.value, viewModel,
                    onItemClick = { symbol ->
                        openExchangeInfoDetails(context, symbol)
                    })
                1 -> ExchangeInfoComposable(
                    viewModel.usdtExchangeInfo.value,
                    viewModel,
                    onItemClick = { symbol ->
                        openExchangeInfoDetails(context, symbol)
                    }
                )
                2 -> ExchangeInfoComposable(
                    viewModel.wrxExchangeInfo.value,
                    viewModel,
                    onItemClick = { symbol ->
                        openExchangeInfoDetails(context, symbol)
                    }
                )
                3 -> ExchangeInfoComposable(
                    viewModel.btcExchangeInfo.value,
                    viewModel,
                    onItemClick = { symbol ->
                        openExchangeInfoDetails(context, symbol)
                    }
                )
            }
        }
    }
}