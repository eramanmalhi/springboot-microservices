package com.lazyprogrammer.employee.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empId;
	@NotEmpty(message = "Employee Name is required")
	private String empName;
	@Email
	private String emailId;
	private Long salary;
	private boolean active;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate doj;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dol;
	@NotEmpty(message = "Department ID is required")
	private Long deptId;
	
	
	public Long getDeptId() {
		return deptId;
	}
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Long getSalary() {
		return salary;
	}
	public void setSalary(Long salary) {
		this.salary = salary;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public LocalDate getDoj() {
		return doj;
	}
	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}
	public LocalDate getDol() {
		return dol;
	}
	public void setDol(LocalDate dol) {
		this.dol = dol;
	}

	public Employee() {
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", emailId=" + emailId + ", salary=" + salary
				+ ", active=" + active + ", doj=" + doj + ", dol=" + dol + ", deptId=" + deptId + "]";
	}
	public Employee(Long empId, String empName, String emailId, Long salary, boolean active, LocalDate doj,
			LocalDate dol, Long deptId) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.emailId = emailId;
		this.salary = salary;
		this.active = active;
		this.doj = doj;
		this.dol = dol;
		this.deptId = deptId;
	}

	
}
