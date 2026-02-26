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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mybuddy.app.viewmodel.FakeDataProvider

@Composable
fun BuddyScreen() {
    val inviteCode = remember { mutableStateOf("") }
    val chats = FakeDataProvider.chats()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("学伴自习室", style = MaterialTheme.typography.titleLarge)
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.padding(vertical = 8.dp)) {
            OutlinedTextField(value = inviteCode.value, onValueChange = { inviteCode.value = it }, label = { Text("邀请码") })
            Button(onClick = { }) { Text("加入") }
        }
        Text("对方今日计划：高数复习、科研整理（完成 1/2）")
        LazyColumn(modifier = Modifier.padding(top = 12.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items(chats) { chat ->
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = if (chat.mine) Arrangement.End else Arrangement.Start) {
                    Card(modifier = Modifier.fillMaxWidth(0.75f)) {
                        Text(chat.content, modifier = Modifier.padding(12.dp))
                    }
                }
            }
        }
        Text("聊天UI参考微信/QQ：气泡+时间线+表情扩展", modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = 8.dp))
    }
}
