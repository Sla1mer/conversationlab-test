package com.conversationlab.testWork.service

import com.conversationlab.testWork.model.Entity.Event
import com.conversationlab.testWork.model.dto.EventRequest
import com.conversationlab.testWork.repository.EventRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class EventService

@Autowired
constructor(
    private val eventRepository: EventRepository
) : EventInterface{
    override fun proccessEventData(eventRequest: EventRequest) {

        val currentDate = eventRequest.date ?: LocalDateTime.now()

        val eventData = Event(text = eventRequest.text, date = currentDate)

        eventRepository.save(eventData)

        notifyUsers(eventData)
    }

    private fun notifyUsers(event: Event) {
        // TODO Здесь должна быть реализация отправки сообщений через Telegram

        // Для примера в консоль выводим
        println("Добавлено событие ${event.text} на дату ${event.date}")
    }
}