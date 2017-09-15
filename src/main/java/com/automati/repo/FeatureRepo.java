package com.automati.repo;

import org.springframework.data.jpa.repository.JpaRepository
;
import org.springframework.stereotype.Repository;

import com.automati.dataentity.Feature;

@Repository
public interface FeatureRepo extends JpaRepository<Feature, Integer> {

}
