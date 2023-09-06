package com.indianbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.indianbank.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
