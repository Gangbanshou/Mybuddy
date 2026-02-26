package com.mybuddy.app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mybuddy.app.viewmodel.FakeDataProvider

@Composable
fun PersonalScreen() {
    val tasks = remember { mutableStateListOf(*FakeDataProvider.tasks().toTypedArray()) }
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("今日任务", style = MaterialTheme.typography.titleLarge)
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.padding(vertical = 8.dp)) {
            listOf("学习", "科研", "生活").forEach { AssistChip(onClick = {}, label = { Text(it) }) }
        }
        Text("可结合拖拽库实现滑动排序（如 compose-reorderable）", style = MaterialTheme.typography.bodySmall)
        LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.padding(top = 8.dp)) {
            itemsIndexed(tasks, key = { _, item -> item.id }) { index, item ->
                Card(modifier = Modifier.fillMaxWidth()) {
                    Row(modifier = Modifier.padding(12.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text("${index + 1}. ${item.title}")
                            Text("分类: ${item.category} | 积分: ${item.points}", style = MaterialTheme.typography.bodySmall)
                            item.deadline?.let { Text("Deadline: $it", style = MaterialTheme.typography.bodySmall) }
                        }
                        Checkbox(checked = item.done, onCheckedChange = {})
                    }
                }
            }
        }
        Text("历史/未来任务：建议接入日历组件 + 水平滑动分页", modifier = Modifier.padding(top = 12.dp))
    }
}
