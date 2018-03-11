package com.project.clinic.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.clinic.models.Nurse;

@Repository("nurseRepository")
public interface NurseRepository extends JpaRepository<Nurse, Integer>{

	List<Nurse> findOneByName(@Param("value") String value);
	
}
