package com.abc.screeningtests.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.abc.screeningtests.entity.Employee;
import com.abc.screeningtests.repo.EmployeeRepository;
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	  @Autowired
	    private EmployeeRepository employeeRepo;
	    @GetMapping
	    public Page<Employee> getEmployees(
	        @RequestParam(required = false) String designation,
	        @RequestParam(required = false) Double minSalary,
	        @RequestParam(required = false) Double maxSalary,
	        @RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "5") int size
	    ) {
	        Pageable pageable = PageRequest.of(page, size);
	        Specification<Employee> spec = EmployeeSpecification.filterEmployees(designation, minSalary, maxSalary);
	        return employeeRepo.findAll(spec, pageable);
	    }
	}

