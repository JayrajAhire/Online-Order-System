package com.lcwd.rating.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.rating.entities.Rating;
import com.lcwd.rating.repositories.RatingRepository;
import com.lcwd.rating.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService {
	
	@Autowired
	private RatingRepository ratingRepo;

	@Override
	public Rating createRating(Rating rating) {
		
		String ratingId = UUID.randomUUID().toString();
		rating.setRatingId(ratingId);
		return ratingRepo.save(rating);
	}

	@Override
	public List<Rating> getRatings() {
		// TODO Auto-generated method stub
		return ratingRepo.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		// TODO Auto-generated method stub
		return ratingRepo.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		// TODO Auto-generated method stub
		return ratingRepo.findByHotelId(hotelId);
	}

}
