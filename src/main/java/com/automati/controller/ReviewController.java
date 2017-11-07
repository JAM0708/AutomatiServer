package com.automati.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.automati.dataentity.Car;
import com.automati.dataentity.Person;
import com.automati.dataentity.Review;
import com.automati.dto.ReviewDTO;
import com.automati.dto.StatusCheck;
import com.automati.service.interfaces.CarServiceInterface;
import com.automati.service.interfaces.PersonServiceInterface;
import com.automati.service.interfaces.ReviewServiceInterface;

@RestController
public class ReviewController {

	@Autowired
	CarServiceInterface carService;
	
	@Autowired
	ReviewServiceInterface reviewService;
	
	@Autowired
	PersonServiceInterface personService;
	
	@RequestMapping(path="/review", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public StatusCheck saveReview(@RequestBody ReviewDTO reviewDTO) {
		Person person = personService.findPersonByEmail(reviewDTO.getPerson().getEmail());
		Car car = carService.getCarById(reviewDTO.getCar().getId());
		Date now = new Date();
		Review review = new Review( reviewDTO.getRating(), now, reviewDTO.getDescription(), person);
		car.addReview(review);
		return carService.save(car);
	}
}
