package com.getinline.repository;

import com.getinline.constant.EventStatus;
import com.getinline.dto.EventDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

// TODO: default delete
public interface EventRepository {

    default List<EventDTO> findEVents(
            Long placeId,
            String eventName,
            EventStatus eventStatus,
            LocalDateTime eventStartDatetime,
            LocalDateTime eventEndDatetime
    ) { return null;}
    default Optional<EventDTO> findEvent(Long eventId) {
        return Optional.empty();
    }
    default boolean insertEvent(EventDTO eventDTO) {
        return false;
    }

    default boolean updateEvent(Long eventId, EventDTO dto) {
        return false;
    }

    default boolean deleteEvent(Long eventId) {
        return false;
    }
}
