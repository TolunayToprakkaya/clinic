package com.project.clinic.services.impl;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.clinic.models.Role;
import com.project.clinic.models.User;
import com.project.clinic.repositories.RoleRepository;
import com.project.clinic.repositories.UserRepository;
import com.project.clinic.services.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public User findOneByEmail(String email) {
		return userRepository.findOneByEmail(email);
	}

	@Override
	public void save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(1);
		Role role = roleRepository.findOneByRole("ADMIN");
		user.setRoles(new HashSet<Role>(Arrays.asList(role)));
		userRepository.save(user);
	}
}
