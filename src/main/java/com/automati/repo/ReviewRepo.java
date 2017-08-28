package com.automati.repo;

import org.springframework.data.jpa.repository.JpaRepository;



import com.automati.dataentity.Review;

public interface ReviewRepo extends JpaRepository<Review, Integer> {

}
