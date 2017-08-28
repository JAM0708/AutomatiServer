package com.automati.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.automati.dataentity.Color;

public interface ColorRepo extends JpaRepository<Color, Integer> {

}
