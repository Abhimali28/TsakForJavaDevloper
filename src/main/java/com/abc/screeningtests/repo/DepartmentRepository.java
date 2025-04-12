package com.abc.screeningtests.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.abc.screeningtests.entity.Department;
import com.abc.screeningtests.entity.Employee;
import com.abc.screeningtests.entity.Salary;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
	
}

	