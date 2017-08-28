package com.automati.repo;

import org.springframework.data.jpa.repository.JpaRepository;



import com.automati.dataentity.ZipCode;

public interface ZipCodeRepo extends JpaRepository<ZipCode, Integer> {

}
