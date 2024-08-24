package com.hotel.rating.controller;

import com.hotel.rating.entity.User;
import com.hotel.rating.payload.ApiResponse;
import com.hotel.rating.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Get all users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUser();
        return ResponseEntity.ok(users);
    }

    int retryCount=1;

    // Get user by ID
    @GetMapping("{user_id}")
//    @CircuitBreaker(name="ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
    //retry won't work along with circuit breaker
//    @Retry(name = "ratingHotelRetry", fallbackMethod = "ratingHotelFallback")
    @RateLimiter(name = "userRateLimiter", fallbackMethod = "userLimiterFallback")
    public ResponseEntity<User> getUserById(@PathVariable("user_id") Integer id){
        System.out.println("Retry count"+ retryCount);
        retryCount++;
        return ResponseEntity.ok(userService.getUserById(id));
    }

    // Create a user
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody @Valid User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(user));
    }

    // Delete user by ID
    @DeleteMapping("{user_id}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable("user_id") Integer id){
        userService.deleteUser(id);
        return new ResponseEntity<>(new ApiResponse("User deleted successfully!", true), HttpStatus.OK);
    }

    //fallback method for circuit breaker
    public ResponseEntity<User> ratingHotelFallback(Integer id, Throwable t){
        User user=User.builder()
                        .email("dummy@gmail.com")
                        .name("dummy")
                        .about("This is a dummy user because some service is down" + t.getMessage())
                        .build();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //fallback method for circuit breaker
    public ResponseEntity<User> userLimiterFallback(Integer id, Throwable t){
        User user = User.builder()
                .email("dummy@gmail.com")
                .name("dummy")
                .about("User service service does not permit further calls")
                .build();
        return new ResponseEntity<>(user, HttpStatus.TOO_MANY_REQUESTS);
    }
}
