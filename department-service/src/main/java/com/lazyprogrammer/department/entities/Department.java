package com.lazyprogrammer.department.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long departmentId;
	private String departmentName;
	private boolean active;

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Department(Long departmentId, String departmentName, boolean active) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.active = active;
	}

	public Department() {
		super();
	}

	@Override
	public String toString() {
		return "Employee [departmentId=" + departmentId + ", departmentName=" + departmentName + ", active=" + active
				+ "]";
	}
}
