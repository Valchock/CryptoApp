package com.example.cryptoapp.presentation.ui

import android.text.Layout
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cryptoapp.presentation.viewModel.CryptoExchangeViewModel
import com.example.cryptoapp.utils.Blue
import com.example.cryptoapp.utils.LightGray
import com.example.cryptoapp.utils.MediumGray

@Composable
fun ExchangeInfoDetailsComposable(symbol: String, viewModel: CryptoExchangeViewModel) {
    val symbolState = viewModel.symbolInfo.value
    val context = LocalContext.current
    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        symbolState.symbolInfo?.let {
            Row(
                Modifier
                    .fillMaxWidth()
                    .background(color = LightGray)
                    .padding(vertical = 8.dp, horizontal = 8.dp)
            ) {
                Text(
                    text = "Symbol : " + symbolState.symbolInfo.symbol,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = MediumGray
                )
            }



            Row(
                horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                    .fillMaxWidth()
                    .background(color = LightGray)
                    .padding(vertical = 8.dp, horizontal = 8.dp)
            ) {
                Text(
                    text = "Base Asset",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = Blue
                )
                Text(
                    text = symbolState.symbolInfo.baseAsset,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = MediumGray
                )
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                    .fillMaxWidth()
                    .background(color = LightGray)
                    .padding(vertical = 8.dp, horizontal = 8.dp)
            ) {
                Text(
                    text = "Quote Asset",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = Blue
                )
                Text(
                    text = symbolState.symbolInfo.quoteAsset,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = MediumGray
                )
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                    .fillMaxWidth()
                    .background(color = LightGray)
                    .padding(vertical = 8.dp, horizontal = 8.dp)
            ) {
                Text(
                    text = "Open Price",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = Blue
                )
                Text(
                    text = symbolState.symbolInfo.openPrice,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = MediumGray
                )
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                    .fillMaxWidth()
                    .background(color = LightGray)
                    .padding(vertical = 8.dp, horizontal = 8.dp)
            ) {
                Text(
                    text = "High Price",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = Blue
                )
                Text(
                    text = symbolState.symbolInfo.highPrice,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = MediumGray
                )
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                    .fillMaxWidth()
                    .background(color = LightGray)
                    .padding(vertical = 8.dp, horizontal = 8.dp)
            ) {
                Text(
                    text = "Last Price",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = Blue
                )
                Text(
                    text = symbolState.symbolInfo.lastPrice,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = MediumGray
                )
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                    .fillMaxWidth()
                    .background(color = LightGray)
                    .padding(vertical = 8.dp, horizontal = 8.dp)
            ) {
                Text(
                    text = "Low Price",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = Blue
                )
                Text(
                    text = symbolState.symbolInfo.lowPrice,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = MediumGray
                )
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                    .fillMaxWidth()
                    .background(color = LightGray)
                    .padding(vertical = 8.dp, horizontal = 8.dp)
            ) {
                Text(
                    text = "Bid Price",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = Blue
                )
                Text(
                    text = symbolState.symbolInfo.bidPrice,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = MediumGray
                )
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                    .fillMaxWidth()
                    .background(color = LightGray)
                    .padding(vertical = 8.dp, horizontal = 8.dp)
            ) {
                Text(
                    text = "Ask Price",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = Blue
                )
                Text(
                    text = symbolState.symbolInfo.askPrice,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = MediumGray
                )
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                    .fillMaxWidth()
                    .background(color = LightGray)
                    .padding(vertical = 8.dp, horizontal = 8.dp)
            ) {
                Text(
                    text = "Volume",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = Blue
                )
                Text(
                    text = symbolState.symbolInfo.volume,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = MediumGray
                )
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                    .fillMaxWidth()
                    .background(color = LightGray)
                    .padding(vertical = 8.dp, horizontal = 8.dp)
            ) {
                Text(
                    text = "AT",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = Blue
                )
                Text(
                    text = symbolState.symbolInfo.at.toString(),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = MediumGray
                )

            }
        }

        if (symbolState.isLoading) {
            CircularProgressIndicator(color = Blue, modifier = Modifier.align(Alignment.CenterHorizontally))
        }

        if (symbolState.error.isNotBlank()) {
            Toast.makeText(context, symbolState.error, Toast.LENGTH_LONG).show()
        }


    }

}