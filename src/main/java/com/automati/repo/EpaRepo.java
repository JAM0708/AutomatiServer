package com.automati.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.automati.dataentity.EPA;

@Repository
public interface EpaRepo extends JpaRepository<EPA, Integer> {

}
