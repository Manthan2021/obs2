package com.coforge.project.obs.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.project.obs.exception.ResourceNotFoundException;
import com.coforge.project.obs.model.Account;
import com.coforge.project.obs.model.Address;
import com.coforge.project.obs.model.Transact;
import com.coforge.project.obs.model.User;
import com.coforge.project.obs.model.UserAddressAccount;
import com.coforge.project.obs.repository.TransactionRepository;
import com.coforge.project.obs.repository.UserRepository;

//http://localhost:9999/obs/data/users
@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/data")
public class LoginRestController {
	
	@Autowired
	private UserRepository uRepo;
	
	@Autowired
	private TransactionRepository tRepo;
	
	
	@PostMapping("/users")
	public UserAddressAccount createuser(@Validated @RequestBody UserAddressAccount user) {
		
	
		Date date = new Date();	 
		Calendar cal = Calendar.getInstance();
		
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
		
		Transact t=new Transact();
		t.setUid(user.getMobilenumber()+"@falcon");
		t.setRecieverid("ADMIN");
		t.setSent(0L);
		t.setReceived(0L);
		t.setBalance(0L);
		t.setDate(date);
		
		u.setAddress(a);
		a.setUser(u);
		
		u.setAccount(acc);
		acc.setUser(u);
		
		uRepo.save(u);
		tRepo.save(t);
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
	
	@GetMapping("/getId/{email}")
    public String gettheId(@PathVariable String email) {
		
		User u=uRepo.findByEmail(email);
		String mobilenumber=u.getMobilenumber();
		String id=mobilenumber+"@falcon";
		return id;
	}
	
	
	@GetMapping("/getName/{email}")
    public String gettheName(@PathVariable String email) {
		
		User u=uRepo.findByEmail(email);
		String First=u.getFirstname();
		String Last=u.getLastname();
		
		return (First+" "+Last);
	}
	
	
	
	@GetMapping("/checkAccount/{uid}")
	public Boolean checkAccount(@PathVariable String uid){
		
		Boolean v=false;
		List<Account> list=uRepo.checkAccount(uid);
		if(list.size()!=0) {
			v=true;
		}
		return v;
	}
	
	
	
}
