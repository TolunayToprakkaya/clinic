package com.project.clinic.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.clinic.models.Doctor;
import com.project.clinic.repositories.DoctorRepository;
import com.project.clinic.services.DoctorService;

@Service("doctorService")
public class DoctorServiceImpl implements DoctorService{

	@Autowired
	private DoctorRepository doctorRepository;
	
	public void setDoctorRepository(DoctorRepository doctorRepository) {
		this.doctorRepository = doctorRepository;
	}
	
	@Override
	public Iterable<Doctor> findAll() {
		return this.doctorRepository.findAll();
	}

	@Override
	public Doctor findOneById(Integer doctor_id) {
		return this.doctorRepository.findOne(doctor_id);
	}

	@Override
	public Doctor save(Doctor doctor) {
		return this.doctorRepository.save(doctor);
	}

	@Override
	public void delete(Integer doctor_id) {
		this.doctorRepository.delete(doctor_id);
	}

}
