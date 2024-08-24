package com.hotel.rating.controller;

import com.hotel.rating.entity.Hotel;
import com.hotel.rating.payload.ApiResponse;
import com.hotel.rating.service.HotelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    // Get all users
    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels(){
        List<Hotel> users = hotelService.getAllHotels();
        return ResponseEntity.ok(users);
    }

    // Get user by ID
    @GetMapping("{hotel_id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable("hotel_id") Integer id){
        return ResponseEntity.ok(hotelService.getHotelById(id));
    }

    // Create a user
    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody @Valid Hotel hotel){
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.createHotel(hotel));
    }

    // Delete user by ID
    @DeleteMapping("{hotel_id}")
    public ResponseEntity<ApiResponse> deleteHotel(@PathVariable("hotel_id") Integer id){
        hotelService.deleteHotel(id);
        return new ResponseEntity<>(new ApiResponse("Hotel deleted successfully!", true), HttpStatus.OK);
    }
}
