package com.lazyprogrammer.department.dto;

import java.util.List;

public class ResponseDto {
	private DepartmentDto department;
	private List<EmployeeDto> employees;

	public ResponseDto() {
	}

	public ResponseDto(DepartmentDto department, List<EmployeeDto> employees) {
		super();
		this.department = department;
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "ResponseDto [department=" + department + ", employees=" + employees + "]";
	}

	public DepartmentDto getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentDto department) {
		this.department = department;
	}

	public List<EmployeeDto> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeDto> employees) {
		this.employees = employees;
	}

}
