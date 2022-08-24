package com.lazyprogrammer.department.dto;

import java.time.LocalDate;

public class EmployeeDto {

	private Long empId;
	private String empName;
	private String emailId;
	private Long salary;
	private boolean active;
	private LocalDate doj;
	private LocalDate dol;
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

	public EmployeeDto() {
	}

	@Override
	public String toString() {
		return "EmployeeDto [empId=" + empId + ", empName=" + empName + ", emailId=" + emailId + ", salary=" + salary
				+ ", active=" + active + ", doj=" + doj + ", dol=" + dol + ", deptId=" + deptId + "]";
	}

	public EmployeeDto(Long empId, String empName, String emailId, Long salary, boolean active, LocalDate doj,
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
