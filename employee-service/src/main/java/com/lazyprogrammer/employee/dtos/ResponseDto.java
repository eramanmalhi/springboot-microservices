package com.lazyprogrammer.employee.dtos;

import java.util.List;

public class ResponseDto {
	private EmployeeDto employee;
	private List<DepartmentDto> department;
	public EmployeeDto getEmployee() {
		return employee;
	}
	public void setEmployee(EmployeeDto employee) {
		this.employee = employee;
	}
	public List<DepartmentDto> getDepartment() {
		return department;
	}
	public void setDepartment(List<DepartmentDto> department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "ResponseDto [employee=" + employee + ", department=" + department + "]";
	}
	public ResponseDto(EmployeeDto employee, List<DepartmentDto> department) {
		super();
		this.employee = employee;
		this.department = department;
	}
	public ResponseDto() {
	}
	
	
}
