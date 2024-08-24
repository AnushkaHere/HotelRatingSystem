package com.hotel.rating.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {

    private int id;
    private String name;
    private String location;
    private String about;

}
