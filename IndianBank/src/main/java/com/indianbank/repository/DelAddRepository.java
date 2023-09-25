package com.indianbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.indianbank.entity.DelAdd;
@Repository
public interface DelAddRepository extends JpaRepository<DelAdd, Long> {

}
