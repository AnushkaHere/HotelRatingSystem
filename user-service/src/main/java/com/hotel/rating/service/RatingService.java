package com.hotel.rating.service;

import com.hotel.rating.payload.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

    @GetMapping("/v1/ratings/users/{userId}")
    Rating[] getRatingsByUserId(@PathVariable("userId") Integer userId);
}
