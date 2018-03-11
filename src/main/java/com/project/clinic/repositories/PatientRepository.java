package com.project.clinic.repositories;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.query.Param;

import com.project.clinic.models.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

	//List<Patient> findOneByName(@Param("value") String value);
	
}
