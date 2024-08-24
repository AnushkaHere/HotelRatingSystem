package com.hotel.rating.service;

import com.hotel.rating.entity.Rating;
import com.hotel.rating.exception.ResourceNotFoundException;
import com.hotel.rating.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating createRating(Rating rating) {
        // ratingId should be null or not set; MongoDB will generate it
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public Rating getRatingById(String id) {
        return ratingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Rating", "Id", id));
    }

    @Override
    public List<Rating> getRatingByUserId(Integer userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(Integer hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }

    @Override
    public void deleteRating(String id) {
        Rating rating = ratingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Rating", "Id", id));
        ratingRepository.delete(rating);
    }
}