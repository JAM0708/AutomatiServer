package com.automati.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.automati.dataentity.Car;
import com.automati.dataentity.Model;
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
		Model model = carService.getModelByName(reviewDTO.getModel().getName());
		Review review = new Review(reviewDTO.getTitle(), reviewDTO.getRating(), now, reviewDTO.getDescription(), person,car, model);
		car.addReview(review);
		reviewService.save(review);
		
		car.setReviewed(true);
		return carService.save(car);
	}
	
	@RequestMapping(path="/reviews", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Review> getListofReviewsByModel(@RequestParam("model") String model) {
		Model modell = carService.getModelByName(model);
		return reviewService.getReviewsByModel(modell);
	}
	
	@RequestMapping(path="/reviewsPeople", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Review> getReviewsByPerson(@RequestParam("email") String email) {
		Person person = personService.findPersonByEmail(email);
		return reviewService.getReviewsByPerson(person);
	}
}
