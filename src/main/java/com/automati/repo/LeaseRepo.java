package com.automati.repo;

import org.springframework.data.jpa.repository.JpaRepository;



import com.automati.dataentity.Lease;

public interface LeaseRepo extends JpaRepository<Lease, Integer> {

}
