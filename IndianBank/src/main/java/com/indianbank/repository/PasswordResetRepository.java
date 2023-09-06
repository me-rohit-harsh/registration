package com.indianbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.indianbank.entity.PasswordReset;

@Repository
public interface PasswordResetRepository extends JpaRepository<PasswordReset, Long> {

}
