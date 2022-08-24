package com.lazyprogrammer.department.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.lazyprogrammer.department.dto.DepartmentDto;
import com.lazyprogrammer.department.dto.EmployeeDto;
import com.lazyprogrammer.department.dto.ResponseDto;
import com.lazyprogrammer.department.entities.Department;
import com.lazyprogrammer.department.repositories.DepartmentRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentRepository departmentRepo;

	@Autowired
	WebClient.Builder webclientBuilder;

	@Autowired
	RestTemplate restTemplate;

	@Override
	public List<DepartmentDto> getDepartments() {
		List<Department> departments = departmentRepo.findAll();
		return entityToDto(departments);
	}

	public List<DepartmentDto> entityToDto(List<Department> departments) {
		List<DepartmentDto> response = new ArrayList<>();
		for (Department dpt : departments) {
			DepartmentDto dto = new DepartmentDto();
			BeanUtils.copyProperties(dpt, dto);
			response.add(dto);
		}
		return response;
	}

	@Override
	public List<DepartmentDto> saveDepartments(List<DepartmentDto> requestObj) {
		List<Department> departments = new ArrayList<>();
		for (DepartmentDto dto : requestObj) {
			Department dpt = new Department();
			BeanUtils.copyProperties(dto, dpt);
			departments.add(dpt);
		}
		List<DepartmentDto> response = new ArrayList<>();
		List<Department> departmentsSaved = new ArrayList<>();
		departmentsSaved = departmentRepo.saveAll(departments);
		for (Department dpt : departmentsSaved) {
			DepartmentDto dto = new DepartmentDto();
			BeanUtils.copyProperties(dpt, dto);
			response.add(dto);
		}
		BeanUtils.copyProperties(departmentsSaved, response);
		return response;
	}

	@Override
	@CircuitBreaker(name="departmentService", fallbackMethod = "getDepartmentsFallback")
	public ResponseDto getDepartments(Long deptId) {
		Optional<Department> deptEntity = departmentRepo.findById(deptId);
		ResponseDto response = new ResponseDto();

		if (deptEntity.isPresent()) {
			DepartmentDto dto = new DepartmentDto();
			BeanUtils.copyProperties(deptEntity.get(), dto);
			response.setDepartment(dto);

			List<EmployeeDto> employees = webclientBuilder.build().get()
					.uri("lb://employee-service/rest-employee-service/employee/department/" + deptId).retrieve()
					.bodyToFlux(EmployeeDto.class).collectList().block();
			response.setEmployees(employees);

			// EmployeeDto[]
			// employees=restTemplate.getForObject("lb://EMPLOYEE-SERVICE/rest-employee-service/employee/"+deptId,
			// EmployeeDto[].class);
			// response.setEmployees(Arrays.asList(employees));
		}
		return response;
	}
	
	public ResponseDto getDepartmentsFallback(Long deptId, Exception e) {
		Optional<Department> deptEntity = departmentRepo.findById(deptId);
		ResponseDto response = new ResponseDto();
		if (deptEntity.isPresent()) {
			DepartmentDto dto = new DepartmentDto();
			BeanUtils.copyProperties(deptEntity.get(), dto);
			response.setDepartment(dto);
			List<EmployeeDto> employees=new ArrayList<>();
			response.setEmployees(employees);
		}
		return response;
	}
}
