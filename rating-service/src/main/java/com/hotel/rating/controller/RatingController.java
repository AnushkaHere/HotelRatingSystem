package com.hotel.rating.controller;

import com.hotel.rating.entity.Rating;
import com.hotel.rating.payload.ApiResponse;
import com.hotel.rating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    //create rating
    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.createRating(rating));
    }

    //get all ratings
    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings(){
        List<Rating> ratings=ratingService.getAllRatings();
        return ResponseEntity.ok(ratings);
    }

    //get rating by id
    @GetMapping("{rating_id}")
    public ResponseEntity<Rating> getRatingById(@PathVariable("rating_id") String ratingId){
        return ResponseEntity.ok(ratingService.getRatingById(ratingId));
    }

    //get rating by user id
    @GetMapping("/users/{user_id}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable("user_id") Integer userId){

        return ResponseEntity.ok(ratingService.getRatingByUserId(userId));
    }

    //get rating by hotel id
    @GetMapping("/hotels/{hotel_id}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable("hotel_id") Integer hotelId){
        return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));
    }

    //delete rating
    @DeleteMapping("{rating_id}")
    public ResponseEntity<ApiResponse> deleteRatingById(@PathVariable("rating_id") String ratingId){
        ratingService.deleteRating(ratingId);
        return new ResponseEntity<>(new ApiResponse("Rating deleted successfully",true),HttpStatus.OK);
    }

}
