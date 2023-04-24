package com.lcwd.user.service.UserService.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lcwd.user.service.UserService.entities.Ratings;
import com.lcwd.user.service.UserService.entities.User;
import com.lcwd.user.service.UserService.exceptions.ResourceNotFoundException;
import com.lcwd.user.service.UserService.repositories.UserRepository;
import com.lcwd.user.service.UserService.services.UserService;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	//private Logger logger = (Logger) LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return userRepo.save(user);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@SuppressWarnings("unchecked")
	@Override
	public User getUser(String userId) {
		// TODO Auto-generated method stub
		User user = userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User not found with id "+userId));
		
		//fetch rating of user based on user
		//ArrayList<Ratings> ratingsOfUser = restTemplate.getForObject("http://localhost:8083/ratings/users/"+userId, ArrayList.class);
		ArrayList<Ratings> ratingsOfUser=restTemplate.getForObject("http://localhost:8083/ratings/users/b4de5169-10fb-4ccf-a2eb-935f5d4505d1", ArrayList.class);
		user.setRatings(ratingsOfUser);
		return user;
	}

}
