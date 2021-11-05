package com.getinline.service;

import com.getinline.constant.EventStatus;
import com.getinline.dto.EventDTO;
import com.getinline.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class EventService {

    private final EventRepository eventRepository;

    public List<EventDTO> getEvents(
            Long placeId,
            String eventName,
            EventStatus eventStatus,
            LocalDateTime eventStartDateTime,
            LocalDateTime eventEndDatetime)
    {
        return List.of();
    }

    public Optional<EventDTO> getEvent(Long eventId) {
        return Optional.empty();
    }

    public boolean createEvent(EventDTO eventDTO) {
        return true;
    }

    public boolean modifyEvent(Long eventId, EventDTO eventDTO) {
        return true;
    }

    public boolean removeEvent(Long eventId) {
        return true;
    }
}
