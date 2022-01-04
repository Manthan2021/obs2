package com.coforge.project.obs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.project.obs.exception.ResourceNotFoundException;
import com.coforge.project.obs.model.Account;
import com.coforge.project.obs.model.Address;
import com.coforge.project.obs.model.User;
import com.coforge.project.obs.model.UserAddressAccount;
import com.coforge.project.obs.repository.UserRepository;

//http://localhost:9999/obs/data/users
@RestController
@RequestMapping(value="/data")
public class LoginRestController {
	
	@Autowired
	private UserRepository uRepo;
	
	
	@PostMapping("/users")
	public UserAddressAccount createuser(@Validated @RequestBody UserAddressAccount user) {
		
		User u=new User();
		u.setEmail(user.getEmail());
		u.setFirstname(user.getFirstname());
		u.setLastname(user.getLastname());
		u.setFathername(user.getFathername());
		u.setDob(user.getDob());
		u.setAadharnumber(user.getAadharnumber());
		u.setPannumber(user.getPannumber());
		u.setPassword(user.getPassword());
		u.setMobilenumber(user.getMobilenumber());
		
		Address a=new Address();
		a.setStreet(user.getStreet());
		a.setCity(user.getCity());
		a.setPincode(user.getPincode());
		a.setCountry(user.getCountry());
		a.setState(user.getState());

		Account acc=new Account();
		acc.setUid(user.getMobilenumber()+"@falcon");
		acc.setMobilenumber(user.getMobilenumber());
		
		u.setAddress(a);
		a.setUser(u);
		
		u.setAccount(acc);
		acc.setUser(u);
		
		uRepo.save(u);
		return user;
		
	}

	@GetMapping("/users")
	public List<UserAddressAccount> getAllDealers(){
		
		return uRepo.fetchUserInnerJoin();
	}
	
	@PostMapping("/userlogin") 
	public Boolean loginDealer(@Validated @RequestBody User user) throws ResourceNotFoundException 
	{
		Boolean a=false;
		String email=user.getEmail();
		String password=user.getPassword();
		
		User d=uRepo.findItByEmail(email).orElseThrow(() ->
		new ResourceNotFoundException("user not exist " + email));
		
		
		if(email.equals(d.getEmail()) && password.equals(d.getPassword()))
		{
			a=true;
		}
		return a;
	}
	
	
	
}
