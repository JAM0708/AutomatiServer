package com.automati.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.automati.dataentity.ResetToken;

@Repository
public interface ResetTokenRepo extends JpaRepository<ResetToken, Integer> {

	ResetToken findResetTokenByTokenNumAndEmail(int tokenNum, String email);
}
