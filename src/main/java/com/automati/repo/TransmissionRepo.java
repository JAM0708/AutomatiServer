package com.automati.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.automati.dataentity.Transmission;

@Repository
public interface TransmissionRepo extends JpaRepository<Transmission, Integer> {

}
