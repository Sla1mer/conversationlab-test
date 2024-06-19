package com.conversationlab.testWork.controller

import com.conversationlab.testWork.model.dto.EventRequest
import com.conversationlab.testWork.service.EventService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class EventController (
    private val eventService: EventService
)
{
    @PostMapping("/form")
    fun submitForm(@RequestBody request: EventRequest): ResponseEntity<String> {
        try {
            eventService.proccessEventData(request)

            return ResponseEntity.ok("Form submitted successfully")
        } catch (e: Exception) {
            return ResponseEntity.badRequest().body(e.message)
        }
    }
}