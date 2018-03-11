package com.project.clinic.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.clinic.models.Patient;
import com.project.clinic.repositories.PatientRepository;
import com.project.clinic.services.PatientService;

@Service("patientService")
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	public void setPatientRepository(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}
	
	@Override
	public Iterable<Patient> findAll() {
		return this.patientRepository.findAll();
	}

	@Override
	public Patient findOneById(Integer patient_id) {
		return this.patientRepository.findOne(patient_id);
	}

	@Override
	public Patient save(Patient patient) {
		return this.patientRepository.save(patient);
	}

	@Override
	public void delete(Integer patient_id) {
		this.patientRepository.delete(patient_id);
	}

	@Override
	public List<Patient> findOneByName(String value) {
		return this.patientService.findOneByName(value);
	}

}
