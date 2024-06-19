package com.conversationlab.testWork.service

import com.conversationlab.testWork.model.dto.EventRequest
import java.time.LocalDateTime

interface EventInterface {
    fun proccessEventData(eventRequest: EventRequest);
}