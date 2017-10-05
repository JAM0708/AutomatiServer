package com.automati.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.automati.dataentity.Condition;

@Repository
public interface ConditionRepo extends JpaRepository<Condition, Integer> {
	
	Condition findConditionByType(String type);
}
