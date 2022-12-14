package com.example.cryptoapp.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cryptoapp.presentation.model.ExchangeInfo
import com.example.cryptoapp.presentation.viewModel.CryptoExchangeViewModel
import com.example.cryptoapp.utils.*
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun ExchangeInfoComposable(
    exchangeInfoList: List<ExchangeInfo>,
    viewModel: CryptoExchangeViewModel,
    onItemClick: (String) -> Unit
) {
    val swipeRefreshState = rememberSwipeRefreshState(
        isRefreshing = viewModel.isRefreshing.value
    )
    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = BlueGray)
                .padding(horizontal = 16.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Base Asset/ Symbol",
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = Blue
            )

            Text(
                text = "LastPrice",
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = Blue
            )

        }
        SwipeRefresh(state = swipeRefreshState, onRefresh = {
            viewModel.isRefreshing.value = true
            viewModel.syncExchangeInfo()
        }) {
            LazyColumn() {
                items(exchangeInfoList) { exchangeInfoItem ->
                    ExchangeInfoItem(exchangeInfoItem, onItemClick)
                }
            }
        }

    }

}

@Composable
fun ExchangeInfoItem(exchangeInfoItem: ExchangeInfo, onItemClick: (String) -> Unit) {

    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable { onItemClick(exchangeInfoItem.symbol) }
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = exchangeInfoItem.baseAsset,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Black
            )

            Text(
                text = exchangeInfoItem.lastPrice,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = MediumGray
            )

        }

        Text(
            text = exchangeInfoItem.symbol,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            color = Blue
        )

        Divider(color = DarkGray, modifier = Modifier.padding(top = 8.dp))

    }

}