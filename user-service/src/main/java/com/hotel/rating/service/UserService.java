package com.hotel.rating.service;

import com.hotel.rating.entity.User;

import java.util.List;

public interface UserService {

    User createUser(User userDto);
    List<User> getAllUser();
    User getUserById(Integer userId);
    void deleteUser(Integer userId);

}
