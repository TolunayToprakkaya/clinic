package com.project.clinic.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.clinic.models.Department;
import com.project.clinic.repositories.DepartmentRepository;
import com.project.clinic.services.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	public void setDepartmentRepository(DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}
	
	@Override
	public Iterable<Department> findAll() {
		return this.departmentRepository.findAll();
	}

}
