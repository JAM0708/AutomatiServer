package com.automati.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.automati.dataentity.State;
import com.automati.dataentity.ZipCode;

@Repository
public interface ZipCodeRepo extends JpaRepository<ZipCode, Integer> {

	List<ZipCode> findZipCodeByState(State state);
}
