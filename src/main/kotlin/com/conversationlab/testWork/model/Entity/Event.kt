package com.conversationlab.testWork.model.Entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document(collection = "event")
data class Event(
    @Id val id: String? = null,
    val text: String,
    val date: LocalDateTime
)
