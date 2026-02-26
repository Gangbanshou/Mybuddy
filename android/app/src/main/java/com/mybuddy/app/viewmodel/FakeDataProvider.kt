package com.mybuddy.app.viewmodel

import com.mybuddy.app.data.model.ChatUiModel
import com.mybuddy.app.data.model.ShopItemUiModel
import com.mybuddy.app.data.model.TaskUiModel
import java.time.LocalDateTime

object FakeDataProvider {
    fun tasks() = mutableListOf(
        TaskUiModel(1, "复习线性代数", "学习", LocalDateTime.now().plusHours(8), 20, false),
        TaskUiModel(2, "整理实验数据", "科研", LocalDateTime.now().plusDays(1), 30, false),
        TaskUiModel(3, "英语听力30分钟", "学习", null, 10, true)
    )

    fun chats() = listOf(
        ChatUiModel(1, false, "今天你打算先做哪项任务？"),
        ChatUiModel(2, true, "我先做高数，再做科研笔记📘"),
        ChatUiModel(3, false, "好，一起冲！💪")
    )

    fun items() = listOf(
        ShopItemUiModel(1, "奶茶券", "完成一周任务奖励", 120),
        ShopItemUiModel(2, "电影夜", "周末娱乐奖励", 300)
    )
}
