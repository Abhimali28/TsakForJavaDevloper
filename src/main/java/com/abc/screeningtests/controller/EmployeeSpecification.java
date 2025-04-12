package com.abc.screeningtests.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import com.abc.screeningtests.entity.Employee;
import com.abc.screeningtests.entity.Salary;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
public class EmployeeSpecification {
	 public static Specification<Employee> filterEmployees(String designation, Double minSalary, Double maxSalary) {
	        return (root, query, cb) -> {
	            List<Predicate> predicates = new ArrayList<>();
	            if (designation != null)
	                predicates.add(cb.equal(root.get("designation"), designation));
	            if (minSalary != null || maxSalary != null) {
	                Join<Employee, Salary> salaryJoin = root.join("salary");
	                if (minSalary != null)
	                    predicates.add(cb.ge(salaryJoin.get("amount"), minSalary));
	                if (maxSalary != null)
	                    predicates.add(cb.le(salaryJoin.get("amount"), maxSalary));
	            }
	            return cb.and(predicates.toArray(new Predicate[0]));
	        };
	    }
}
