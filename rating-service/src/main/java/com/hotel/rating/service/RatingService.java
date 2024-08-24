package com.hotel.rating.service;

import com.hotel.rating.entity.Rating;

import java.util.List;

public interface RatingService {

    Rating createRating(Rating rating);
    List<Rating> getAllRatings();
    Rating getRatingById(String id);
    List<Rating> getRatingByUserId(Integer userId);
    List<Rating> getRatingByHotelId(Integer hotelId);
    void deleteRating(String id);
}
