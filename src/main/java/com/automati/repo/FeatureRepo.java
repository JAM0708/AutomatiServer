package com.automati.repo;

import org.springframework.data.jpa.repository.JpaRepository
;


import com.automati.dataentity.Feature;

public interface FeatureRepo extends JpaRepository<Feature, Integer> {

}
