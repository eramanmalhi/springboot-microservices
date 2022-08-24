package com.lazyprogrammer.employee.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lazyprogrammer.employee.dtos.EmployeeDto;
import com.lazyprogrammer.employee.services.EmployeeService;

@RestController
@RequestMapping("/rest-employee-service")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("employee")
	public List<EmployeeDto> findAllEmployees(){
		return employeeService.findAllEmployees();
	}
	
	@PostMapping("save/employee")
	public List<EmployeeDto> saveEmployees(@RequestBody(required = true) List<EmployeeDto> employees){
		System.out.println("Saving Employees");
		return employeeService.saveEmployees(employees);
	}
	
	@GetMapping("employee/department/{deptId}")
	public List<EmployeeDto> findAllEmployeesForDepartment(@PathVariable(name="deptId") Long deptId){
		return employeeService.findAllEmployeesForDepartment(deptId);
	}
	

}
