package com.coforge.project.obs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coforge.project.obs.model.User;
import com.coforge.project.obs.repository.UserRepository;

@Service
@Transactional

public class LoginService {
	
	@Autowired
	public UserRepository uRepo;
	
	public void saveUser(User user) {
		uRepo.save(user);//invokes save for JPa
	}
	
	public User findByEmail(String email)  {
		
		return uRepo.findByEmail(email);	
		}

}
