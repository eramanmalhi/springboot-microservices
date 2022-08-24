package com.lazyprogrammer.department.dto;

public class DepartmentDto {
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

	public DepartmentDto(Long departmentId, String departmentName, boolean active) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.active = active;
	}

	public DepartmentDto() {
		super();
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", active=" + active
				+ "]";
	}

}
