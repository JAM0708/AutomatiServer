package com.automati.repo;

import org.springframework.data.jpa.repository.JpaRepository;



import com.automati.dataentity.Transmission;

public interface TransmissionRepo extends JpaRepository<Transmission, Integer> {

}
