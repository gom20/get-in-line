package com.getinline.controller.api;

import com.getinline.constant.PlaceType;
import com.getinline.dto.APIDataResponse;
import com.getinline.dto.PlaceDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class APIPlaceController {

    @GetMapping("/places")
    public APIDataResponse<List<PlaceDTO>> getPlaces() {
        return  APIDataResponse.of(List.of(PlaceDTO.of(
                PlaceType.COMMON,
                "랄라탁구장",
                "경기도 이천시",
                "123-1111-2222",
                30,
                "신장개업"
        )));
    }

    @PostMapping("/places")
    public Boolean createPlace() {
        return true;
    }

    @GetMapping("/places/{placeId}")
    public APIDataResponse<PlaceDTO> getPlace(@PathVariable Integer placeId){
        if (placeId.equals(2)) {
            return APIDataResponse.of(null);
        }

        return  APIDataResponse.of(PlaceDTO.of(
                PlaceType.COMMON,
                "랄라탁구장",
                "경기도 이천시",
                "123-1111-2222",
                30,
                "신장개업"
        ));
    }

    @PutMapping("/places/{placeId}")
    public Boolean modifyPlace(@PathVariable Integer placeId){
        return true;
    }

    @DeleteMapping("/places/{placeId}")
    public Boolean removePlace(@PathVariable Integer placeId){
        return true;
    }

}
