package com.getinline.domain;

import com.getinline.constant.PlaceType;

import java.time.LocalDateTime;

public class Plcae {
    private Long id;

    private PlaceType placeType;
    private String placeName;
    private String address;
    private String phoneNumber;
    private Integer capacity;
    private String memo;

    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;


}
