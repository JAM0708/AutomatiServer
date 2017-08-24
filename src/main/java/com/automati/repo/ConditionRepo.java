package com.automati.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.automati.dataentity.Condition;

public interface ConditionRepo extends JpaRepository<Condition, Integer> {

}
