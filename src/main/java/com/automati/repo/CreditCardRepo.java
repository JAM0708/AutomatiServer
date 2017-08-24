package com.automati.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.automati.dataentity.CreditCard;

public interface CreditCardRepo extends JpaRepository<CreditCard, Integer> {

}
