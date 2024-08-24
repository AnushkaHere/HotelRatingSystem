package com.hotel.rating.service;

import com.hotel.rating.payload.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="HOTEL-SERVICE")
public interface HotelService {

    @GetMapping("/v1/hotels/{hotel_id}")
    Hotel getHotel(@PathVariable("hotel_id") String hotelId);
}
