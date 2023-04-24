package com.lcwd.hotel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.hotel.entities.Hotel;
import com.lcwd.hotel.services.HotelServices;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	
	@Autowired
	private HotelServices hotelService;

	
	//create
	@PostMapping
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
		
		Hotel created = hotelService.createHotel(hotel);
		
		return new ResponseEntity<Hotel>(created,HttpStatus.CREATED);
	}
	
	
	
	//get one
	@GetMapping("/{id}")
   public ResponseEntity<Hotel> getHotelwithId(@PathVariable String id){
		
		Hotel getHotel = hotelService.getHotel(id);
		
		return new ResponseEntity<Hotel>(getHotel,HttpStatus.OK);
	}
	
	//get all
	@GetMapping
	public ResponseEntity<List<Hotel>> getAllHotels(){
		List<Hotel> getAll = hotelService.getAllHotels();
		return new ResponseEntity<List<Hotel>>(getAll,HttpStatus.OK);
	}
}
