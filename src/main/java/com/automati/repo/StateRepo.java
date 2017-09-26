package com.automati.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.automati.dataentity.State;

@Repository
public interface StateRepo extends JpaRepository<State, Integer> {

	State findStateByName(String name);
	

}
