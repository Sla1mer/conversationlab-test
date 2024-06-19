package com.conversationlab.testWork.model.dto

import java.time.LocalDateTime

data class EventRequest(
    val text: String,
    val date: LocalDateTime?
)
