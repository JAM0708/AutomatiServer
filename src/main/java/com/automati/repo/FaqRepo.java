package com.automati.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.automati.dataentity.Color;
import com.automati.dataentity.Faq;

@Repository
public interface FaqRepo extends JpaRepository<Faq, Integer> {

}
