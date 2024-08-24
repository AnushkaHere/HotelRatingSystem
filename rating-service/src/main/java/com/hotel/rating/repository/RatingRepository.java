package com.hotel.rating.repository;

import com.hotel.rating.entity.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface RatingRepository extends MongoRepository<Rating, String> {
    List<Rating> findByUserId(Integer userId);
    List<Rating> findByHotelId(Integer hotelId);
}
