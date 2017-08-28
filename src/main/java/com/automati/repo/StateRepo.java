package com.automati.repo;

import org.springframework.data.jpa.repository.JpaRepository;



import com.automati.dataentity.State;

public interface StateRepo extends JpaRepository<State, Integer> {

}
