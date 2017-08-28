package com.automati.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.automati.dataentity.Person;
import com.automati.dataentity.Review;

public interface ReviewRepo extends JpaRepository<Review, Integer> {
	
	List<Review> findReviewsByPerson(Person person);
}
