package com.lazyprogrammer.department.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lazyprogrammer.department.dto.DepartmentDto;
import com.lazyprogrammer.department.dto.ResponseDto;
import com.lazyprogrammer.department.services.DepartmentService;

@RestController
@RequestMapping("/rest-department-service")
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;

	@GetMapping("/department")
	public List<DepartmentDto> getDepartments() {
		return departmentService.getDepartments();
	}

	@GetMapping("/department/{deptId}")
	public ResponseDto getDepartment(@PathVariable(name = "deptId") Long deptId) {
		return departmentService.getDepartments(deptId);
	}

	@PostMapping("/save/department")
	public List<DepartmentDto> saveDepartments(@RequestBody List<DepartmentDto> requestObj) {
		return departmentService.saveDepartments(requestObj);
	}

}
