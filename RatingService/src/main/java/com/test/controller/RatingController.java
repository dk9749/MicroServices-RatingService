package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Rating;
import com.test.servicesimpl.RatingServiceImpl;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	RatingServiceImpl impl;

	@PreAuthorize("hasAuthority('Admin')")
	@PostMapping
	public ResponseEntity<Rating> saveRating(@RequestBody Rating rating) {
		Rating saveRating = impl.saveRating(rating);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveRating);
	}

	@PreAuthorize("hasAuthority('admin')")
	@GetMapping
	public ResponseEntity<List<Rating>> getAllRating() {
		List<Rating> allRating = impl.getAllRating();
		return ResponseEntity.status(HttpStatus.OK).body(allRating);
	}

	@PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('Admin')")
	@GetMapping("/user/{id}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String id) {
		List<Rating> ratingByUserId = impl.getRatingByUserId(id);
		return ResponseEntity.status(HttpStatus.OK).body(ratingByUserId);
	}

	@PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('Admin')")
	@GetMapping("/hotel/{id}")
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String id) {
		List<Rating> ratingByHotelId = impl.getRatingByHotelId(id);
		return ResponseEntity.status(HttpStatus.OK).body(ratingByHotelId);
	}
}
