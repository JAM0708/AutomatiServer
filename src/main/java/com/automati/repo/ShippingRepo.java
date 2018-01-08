package com.automati.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.automati.dataentity.Person;
import com.automati.dataentity.Shipping;

@Repository
public interface ShippingRepo extends JpaRepository<Shipping, Integer> {

		List<Shipping> findShippingsByPerson(Person person);
}
