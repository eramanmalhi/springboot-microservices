package com.lazyprogrammer.department.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lazyprogrammer.department.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
