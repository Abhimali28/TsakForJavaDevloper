package com.abc.screeningtests.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.screeningtests.entity.Department;
import com.abc.screeningtests.entity.Employee;
import com.abc.screeningtests.repo.DepartmentRepository;
import com.abc.screeningtests.repo.EmployeeRepository;
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
	 @Autowired
	    private DepartmentRepository departmentRepo;
	    @Autowired
	    private EmployeeRepository employeeRepo;
	    @PostMapping
	    public Department createDepartment(@RequestBody Department department) {
	        return departmentRepo.save(department);
	    }
	    @PostMapping("/{deptId}/employees")
	    public Employee createEmployee(@PathVariable Long deptId, @RequestBody Employee employee) {
	        Department department = departmentRepo.findById(deptId)
	                                  .orElseThrow(() -> new RuntimeException("Department not found"));
	        employee.setDepartment(department);
	        return employeeRepo.save(employee);
	    }
	    @GetMapping("/{deptId}/employees")
	    public List<Employee> getEmployeesByDepartment(@PathVariable Long deptId) {
	        return departmentRepo.findById(deptId)
	            .map(Department::getEmployees)
	            .orElseThrow(() -> new RuntimeException("Department not found"));
	    }
}
