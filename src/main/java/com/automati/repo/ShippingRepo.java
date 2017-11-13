package com.automati.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.automati.dataentity.Shipping;

@Repository
public interface ShippingRepo extends JpaRepository<Shipping, Integer> {

}
