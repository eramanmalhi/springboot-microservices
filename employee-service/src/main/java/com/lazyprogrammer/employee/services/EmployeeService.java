package com.lazyprogrammer.employee.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lazyprogrammer.employee.dtos.EmployeeDto;

@Service
public interface EmployeeService {

	public List<EmployeeDto> findAllEmployees();

	public List<EmployeeDto> saveEmployees(List<EmployeeDto> employees);

	public List<EmployeeDto> findAllEmployeesForDepartment(Long deptId);
}
