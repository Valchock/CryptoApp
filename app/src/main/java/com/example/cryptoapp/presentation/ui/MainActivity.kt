package com.example.cryptoapp.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
        viewModel = ViewModelProvider(this)[CryptoExchangeViewModel::class.java]
        viewModel.syncExchangeInfo()
        viewModel.getINRExchangeInfo()
        viewModel.getBTCExchangeInfo()
        viewModel.getUSDTExchangeInfo()
        viewModel.getWRXExchangeInfo()
        setContent {
            TabLayout()

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
        HorizontalPager(state = pagerState) { page ->
            when (page) {
                0 -> ExchangeInfoComposable(viewModel.inrExchangeInfo.value)
                1 -> ExchangeInfoComposable(viewModel.usdtExchangeInfo.value)
                2 -> ExchangeInfoComposable(viewModel.wrxExchangeInfo.value)
                3 -> ExchangeInfoComposable(viewModel.btcExchangeInfo.value)
            }
        }
    }


    @Composable
    fun TabContentScreen(data: String) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = data,
                style = MaterialTheme.typography.h5,
                color = DarkGray,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
    }
}