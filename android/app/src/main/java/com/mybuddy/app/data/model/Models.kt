package com.mybuddy.app.data.model

import java.time.LocalDateTime

data class TaskUiModel(
    val id: Long,
    val title: String,
    val category: String,
    val deadline: LocalDateTime?,
    val points: Int,
    val done: Boolean
)

data class ChatUiModel(
    val id: Long,
    val mine: Boolean,
    val content: String
)

data class ShopItemUiModel(
    val id: Long,
    val name: String,
    val desc: String,
    val cost: Int
)
