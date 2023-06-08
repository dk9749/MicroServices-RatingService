package com.test.services;

import java.util.List;

import com.test.entity.Rating;

public interface RatingService {

	Rating saveRating(Rating rating);

	List<Rating> getAllRating();

	List<Rating> getRatingByUserId(String id);

	List<Rating> getRatingByHotelId(String id);
}
