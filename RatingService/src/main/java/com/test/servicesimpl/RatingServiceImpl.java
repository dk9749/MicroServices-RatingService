package com.test.servicesimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.test.entity.Rating;
import com.test.services.RatingService;

@Service
public class RatingServiceImpl implements RatingService {
	static List<Rating> list = new ArrayList<>();

	@Autowired
	RestTemplate restTemplate;

	public RatingServiceImpl() {
		Rating rating = new Rating("301", "101", "201", "9", "very nice service");
		Rating rating1 = new Rating("302", "101", "202", "5", "ok service");
		Rating rating2 = new Rating("303", "101", "203", "2", "very bad service");
		Rating rating3 = new Rating("304", "102", "202", "7", "good service");
		Rating rating4 = new Rating("305", "102", "203", "1", "bad service");
		list.add(rating);
		list.add(rating1);
		list.add(rating2);
		list.add(rating3);
		list.add(rating4);
	}

	@Override
	public Rating saveRating(Rating rating) {
		String random = UUID.randomUUID().toString();
		rating.setRatingId(random);
		list.add(rating);
		return rating;
	}

	@Override
	public List<Rating> getAllRating() {
		return list;
	}

	@Override
	public List<Rating> getRatingByUserId(String id) {
		List<Rating> list1 = new ArrayList<>();
		for (Rating z : list) {
			if (z.getUserId().equals(id)) {
				list1.add(z);
			}
		}
		return list1;
	}

	@Override
	public List<Rating> getRatingByHotelId(String id) {
		List<Rating> list1 = new ArrayList<>();
		for (Rating z : list) {
			if (z.getHotelId().equals(id)) {
				list1.add(z);
			}
		}
		return list1;
	}

}
