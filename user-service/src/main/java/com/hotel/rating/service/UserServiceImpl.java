package com.hotel.rating.service;

import com.hotel.rating.entity.User;
import com.hotel.rating.exception.ResourceNotFoundException;
import com.hotel.rating.payload.Hotel;
import com.hotel.rating.payload.Rating;
import com.hotel.rating.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private RatingService ratingService;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {

        List<User> users = userRepository.findAll();

        return users.stream().map(user -> {
            // Fetch ratings for the user via Feign Client
            Rating[] userRatings = ratingService.getRatingsByUserId(user.getId());

            // Convert array to list and map each rating to include the associated hotel
            List<Rating> ratingList = Arrays.stream(userRatings).map(rating -> {
                // Fetch the hotel via Feign Client
                Hotel hotel = hotelService.getHotel(rating.getHotelId());
                rating.setHotel(hotel);
                return rating;
            }).collect(Collectors.toList());

            // Set the ratings in the user object
            user.setRatings(ratingList);
            return user;
        }).collect(Collectors.toList());
    }

    @Override
    public User getUserById(Integer userId) {

        // Fetch the user or throw an exception if not found
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        // Fetch ratings for the user via Feign Client
        Rating[] userRatings = ratingService.getRatingsByUserId(userId);

        // Convert array to list and map each rating to include the associated hotel
        List<Rating> ratingList = Arrays.stream(userRatings).map(rating -> {
            // Fetch the hotel via Feign Client
            Hotel hotel = hotelService.getHotel(rating.getHotelId());
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());

        // Set the ratings in the user object
        user.setRatings(ratingList);

        return user;
    }

    @Override
    public void deleteUser(Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        userRepository.delete(user);
    }
}
