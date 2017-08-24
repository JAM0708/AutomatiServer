package com.automati.repo;

import org.springframework.data.jpa.repository.JpaRepository;



import com.automati.dataentity.Model;

public interface ModelRepo extends JpaRepository<Model, Integer> {

}
