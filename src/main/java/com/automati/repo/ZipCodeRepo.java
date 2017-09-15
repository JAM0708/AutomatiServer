package com.automati.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.automati.dataentity.ZipCode;

@Repository
public interface ZipCodeRepo extends JpaRepository<ZipCode, Integer> {

}
