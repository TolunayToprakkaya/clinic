package com.project.clinic.services;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.project.clinic.models.Patient;

public interface PatientService {

	Iterable<Patient> findAll();
	Patient findOneById(Integer patient_id);
	Patient save(Patient patient);
	void delete(Integer patient_id);
	
	List<Patient> findOneByName(@Param("value") String value);
	
}
