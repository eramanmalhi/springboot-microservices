package com.lazyprogrammer.department.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lazyprogrammer.department.dto.DepartmentDto;
import com.lazyprogrammer.department.dto.ResponseDto;

@Service
public interface DepartmentService {

	List<DepartmentDto> getDepartments();

	List<DepartmentDto> saveDepartments(List<DepartmentDto> requestObj);

	ResponseDto getDepartments(Long deptId);

}
