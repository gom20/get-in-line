package com.getinline.service;

import com.getinline.constant.EventStatus;
import com.getinline.dto.EventDTO;
import com.getinline.repository.EventRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class EventServiceTest {


    @InjectMocks
    private EventService sut;

    @Mock
    private EventRepository eventRepository;

//    @DisplayName("검색 조건 없이 이벤트 검색하면, 검색 결과를 출력하여 보여준다.")
//    @Test
//    void givenNothing_whenSearchingEvents_thenReturnsEntireEventList() {
//        // Given
//        given(eventRepository.findEvents(null, null, null, null, null))
//                .willReturn(List.of(
//                        createEventDTO(1L, "오전 운동", true),
//                        createEventDTO(1L, "오후 운동", false)
//                ));
//
//        // When
//        List<EventDTO> events = sut.getEvents(null, null, null, null, null);
//
//        // Then
//        assertThat(events).isNotNull();
//        assertThat(events).hasSize(2);
//        then(eventRepository).should().findEvents(null, null, null, null, null);
//    }


    @DisplayName("검색 조건 함꼐 검색하면, 검색 결과를 출력하여 보여준다.")
    @Test
    void givenSearchParams_whenSearchingEvents_thenReturnsEventList() {
        // Given
        Long placeId = 1L;
        String eventName = "오전 운동";
        EventStatus eventStatus = EventStatus.OPENED;
        LocalDateTime eventStartDateTime = LocalDateTime.of(2021,1,1,0,0,0);
        LocalDateTime eventEndDatetime = LocalDateTime.of(2021, 1, 2, 0, 0, 0);


        // When
        List<EventDTO> events = sut.getEvents(
                placeId, eventName, eventStatus, eventStartDateTime, eventEndDatetime);

        // Then
        assertThat(events)
                .isNotNull()
                .allSatisfy(event -> {
                    assertThat(event)
                            .hasFieldOrPropertyWithValue("placeId", placeId)
                            .hasFieldOrPropertyWithValue("eventName", eventName)
                            .hasFieldOrPropertyWithValue("eventStatus", eventStatus);
                    assertThat(event.eventStartDateTime()).isAfterOrEqualTo(eventStartDateTime);
                    assertThat(event.eventEndDatetime()).isBeforeOrEqualTo(eventEndDatetime);
                });
    }
}