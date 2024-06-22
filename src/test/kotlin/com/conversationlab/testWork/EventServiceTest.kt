package com.conversationlab.testWork

import com.conversationlab.testWork.model.Entity.Event
import com.conversationlab.testWork.model.dto.EventRequest
import com.conversationlab.testWork.repository.EventRepository
import com.conversationlab.testWork.service.EventService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import java.time.LocalDateTime

class EventServiceTest {

    @Mock
    private lateinit var eventRepository: EventRepository

    @InjectMocks
    private lateinit var eventService: EventService

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun proccessEventDataShouldSaveEvent() {
        val request = EventRequest("Test Event", null)
        val currentDate = LocalDateTime.now()
        `when`(eventRepository.save(Event("1", "Test Event", currentDate)))
            .thenReturn(Event("1", "Test Event", currentDate)) // Example ID and event returned by save

        eventService.proccessEventData(request)

        verify(eventRepository).save(Event("1","Test Event", currentDate))
    }

    @Test
    fun proccessEventDataNotCurrentDateShouldSaveEvent() {
        val request = EventRequest("Test Event", null)
        `when`(eventRepository.save(Event("1", "Test Event", null)))
            .thenReturn(Event("1", "Test Event", LocalDateTime.now())) // Example ID and event returned by save

        eventService.proccessEventData(request)

        verify(eventRepository).save(Event("1","Test Event", LocalDateTime.now()))
    }
}