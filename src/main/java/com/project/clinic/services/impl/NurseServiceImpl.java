package com.project.clinic.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.clinic.models.Nurse;
import com.project.clinic.repositories.NurseRepository;
import com.project.clinic.services.NurseService;

@Service("nurseService")
public class NurseServiceImpl implements NurseService{

	@Autowired
	private NurseRepository nurseRepository;
	
	public void setNurseRepository(NurseRepository nurseRepository) {
		this.nurseRepository = nurseRepository;
	}
	
	@Override
	public Iterable<Nurse> findAll() {
		return this.nurseRepository.findAll();
	}

	@Override
	public Nurse findOneById(Integer nurse_id) {
		return this.nurseRepository.findOne(nurse_id);
	}

	@Override
	public Nurse save(Nurse nurse) {
		return this.nurseRepository.save(nurse);
	}

	@Override
	public void delete(Integer nurse_id) {
		this.nurseRepository.delete(nurse_id);
	}

}
