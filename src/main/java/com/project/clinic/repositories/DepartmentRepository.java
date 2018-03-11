package com.project.clinic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.clinic.models.Department;

@Repository("departmentRepository")
public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
