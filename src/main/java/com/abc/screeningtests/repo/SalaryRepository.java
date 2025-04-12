package com.abc.screeningtests.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.screeningtests.entity.Salary;

public interface SalaryRepository extends JpaRepository<Salary, Long> {
	
} 


