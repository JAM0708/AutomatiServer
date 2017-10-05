package com.automati.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.automati.dataentity.Model;

@Repository
public interface ModelRepo extends JpaRepository<Model, Integer> {
	
	Model findModelByName(String name);
}
