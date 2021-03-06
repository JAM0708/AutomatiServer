package com.automati.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.automati.dataentity.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {
	
	Role findRoleByName(String name);
}
