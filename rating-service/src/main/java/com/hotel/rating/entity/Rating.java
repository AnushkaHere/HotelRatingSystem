package com.hotel.rating.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("ratings")
public class Rating {

    @MongoId(FieldType.OBJECT_ID)
    private String ratingId;
    private int userId;
    private int hotelId;
    private int rating;
    private String feedback;

}
