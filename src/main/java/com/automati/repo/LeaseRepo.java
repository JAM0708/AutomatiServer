package com.automati.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.automati.dataentity.Lease;

@Repository
public interface LeaseRepo extends JpaRepository<Lease, Integer> {

}
