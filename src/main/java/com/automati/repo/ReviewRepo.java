package com.automati.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.automati.dataentity.Person;
import com.automati.dataentity.Review;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Integer> {
	
	List<Review> findReviewsByPerson(Person person);
}
