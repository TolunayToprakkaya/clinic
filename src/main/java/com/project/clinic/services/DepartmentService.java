package com.project.clinic.services;

import com.project.clinic.models.Department;

public interface DepartmentService {

	Iterable<Department> findAll();
	
}
