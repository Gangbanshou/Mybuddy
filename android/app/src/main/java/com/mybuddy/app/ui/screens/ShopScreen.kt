package com.mybuddy.app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mybuddy.app.viewmodel.FakeDataProvider

@Composable
fun ShopScreen() {
    val items = FakeDataProvider.items()
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("积分商城", style = MaterialTheme.typography.titleLarge)
        Text("仅展示自己或学伴授权商品")
        LazyColumn(modifier = Modifier.padding(top = 12.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items(items) { item ->
                Card(modifier = Modifier.fillMaxWidth()) {
                    Row(modifier = Modifier.padding(12.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(item.name)
                            Text(item.desc, style = MaterialTheme.typography.bodySmall)
                            Text("${item.cost} 积分", style = MaterialTheme.typography.bodySmall)
                        }
                        Button(onClick = { }) { Text("兑换") }
                    }
                }
            }
        }
    }
}
