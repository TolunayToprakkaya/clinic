package com.project.clinic.services;

import com.project.clinic.models.User;

public interface UserService {

	public User findOneByEmail(String email);
	public void save(User user);
	
}
