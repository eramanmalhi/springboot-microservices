package com.lazyprogrammer.employee.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lazyprogrammer.employee.dtos.EmployeeDto;
import com.lazyprogrammer.employee.entities.Employee;
import com.lazyprogrammer.employee.repositories.EmployeeRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<EmployeeDto> findAllEmployees() {
		List<Employee> empEntitiesList = employeeRepository.findAll();
		return entityToDto(empEntitiesList);
	}

	@Override
	public List<EmployeeDto> saveEmployees(List<EmployeeDto> employees) {
		List<Employee> emps = dtoToEntity(employees);
		return entityToDto(employeeRepository.saveAll(emps));
	}

	public List<EmployeeDto> entityToDto(List<Employee> empEntitiesList) {
		List<EmployeeDto> response = new ArrayList<>();
		for (Employee emp : empEntitiesList) {
			EmployeeDto empDto = new EmployeeDto();
			BeanUtils.copyProperties(emp, empDto);
			response.add(empDto);
		}
		return response;
	}

	public List<Employee> dtoToEntity(List<EmployeeDto> empDtoList) {
		List<Employee> response = new ArrayList<>();
		for (EmployeeDto empDto : empDtoList) {
			Employee emp = new Employee();
			BeanUtils.copyProperties(empDto, emp);
			response.add(emp);
		}
		return response;
	}

	@Override
	public List<EmployeeDto> findAllEmployeesForDepartment(Long deptId) {
		return entityToDto(employeeRepository.findByDeptId(deptId));

	}

}
