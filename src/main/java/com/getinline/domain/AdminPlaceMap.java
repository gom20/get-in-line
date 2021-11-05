package com.getinline.domain;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class AdminPlaceMap {
    private Long id;

    private Long adminId;
    private Long placeId;

    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;

}
