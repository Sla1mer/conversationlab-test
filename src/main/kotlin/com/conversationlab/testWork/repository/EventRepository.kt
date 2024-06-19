package com.conversationlab.testWork.repository

import com.conversationlab.testWork.model.Entity.Event
import org.springframework.data.mongodb.repository.MongoRepository

interface EventRepository : MongoRepository<Event, String> {
}