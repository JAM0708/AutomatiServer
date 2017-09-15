package com.automati.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.automati.dataentity.Color;

@Repository
public interface ColorRepo extends JpaRepository<Color, Integer> {

}
