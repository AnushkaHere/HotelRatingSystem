package com.hotel.rating.service;

import com.hotel.rating.entity.Hotel;

import java.util.List;

public interface HotelService {

    Hotel createHotel(Hotel hotel);
    List<Hotel> getAllHotels();
    Hotel getHotelById(Integer hotelId);
    void deleteHotel(Integer hotelId);

}
