package com.project.clinic.services;

import com.project.clinic.models.Nurse;

public interface NurseService {

	Iterable<Nurse> findAll();
	Nurse findOneById(Integer nurse_id);
	Nurse save(Nurse nurse);
	void delete(Integer nurse_id);
	
}
