package com.automati.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.automati.dataentity.Car;
import com.automati.dataentity.Model;
import com.automati.dataentity.Person;
import com.automati.dataentity.Review;
import com.automati.dto.StatusCheck;
import com.automati.repo.CarRepo;
import com.automati.repo.ReviewRepo;
import com.automati.service.interfaces.ReviewServiceInterface;

@Service
@Transactional
public class ReviewService implements ReviewServiceInterface {

	@Autowired
	private ReviewRepo reviewRepo;
	
	@Autowired
	private CarRepo carRepo;
	
	@Autowired
	@Qualifier("status-check")
	private StatusCheck status;


	@Override
	public <T> StatusCheck save(T object) {
		boolean passed = false;
		if (object instanceof Review) {
			Review review = (Review) object;
			reviewRepo.save(review);
			status.setPassedTrue();
			return status;
		} else {
			status.setPassedFalse();
			return status;
		}
	}

	@Override
	public <T> void delete(T object) {
		if (object instanceof Review) {
			reviewRepo.delete((Review) object);
		}
	}

	@Override
	public <T> void update(T object) {
		if (object instanceof Review) {
			reviewRepo.save((Review) object);
		}
	}

	@Override
	public List<Review> getReviewsByModel(Model model) {
		// TODO Auto-generated method stub
		return reviewRepo.findReviewsByModel(model);
	}

	@Override
	public Review getReviewByCar(Car car) {
		// TODO Auto-generated method stub
		return reviewRepo.findReviewByCar(car);
	}

	@Override
	public List<Review> getReviewsByPerson(Person person) {
		// TODO Auto-generated method stub
		return reviewRepo.findReviewsByPerson(person);
	}

}
