package com.abc.screeningtests.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
@Entity
public class Employee {
	  @Id @GeneratedValue
	    private Long id;
	    private String name;
	    
	  
	    private String designation;

	    private LocalDate joiningDate;
	    

	    @ManyToOne
	 @JsonBackReference
	    private Department department;

	    @OneToOne(cascade = CascadeType.ALL)
	    private Salary salary;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDesignation() {
			return designation;
		}

		public void setDesignation(String designation) {
			this.designation = designation;
		}

		public LocalDate getJoiningDate() {
			return joiningDate;
		}

		public void setJoiningDate(LocalDate joiningDate) {
			this.joiningDate = joiningDate;
		}

		public Department getDepartment() {
			return department;
		}

		public void setDepartment(Department department) {
			this.department = department;
		}

		public Salary getSalary() {
			return salary;
		}

		public void setSalary(Salary salary) {
			this.salary = salary;
		}
	    
	}

