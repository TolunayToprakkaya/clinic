package com.project.clinic.services;

import com.project.clinic.models.Doctor;

public interface DoctorService {

	Iterable<Doctor> findAll();
	Doctor findOneById(Integer doctor_id);
	Doctor save(Doctor doctor);
	void delete(Integer doctor_id);
}
