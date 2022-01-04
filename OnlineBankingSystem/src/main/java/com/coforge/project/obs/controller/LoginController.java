package com.coforge.project.obs.controller;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.coforge.project.obs.model.Account;
import com.coforge.project.obs.model.Address;
import com.coforge.project.obs.model.User;
import com.coforge.project.obs.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService lservice;
	
	@RequestMapping("/")
	public String viewHomePage() {
		return "index";
	}

@RequestMapping("/register")
	
	public String viewRegisterPage(Model model) {
		User user=new User();
	    model.addAttribute(user);
	    return "register";//returns model and view
	
	}

@PostMapping("/saveUser")
public String saveUser(HttpServletRequest req,@ModelAttribute("user") User user) {
	
	
	String country=req.getParameter("country");
	String state=req.getParameter("state");
	String city=req.getParameter("city");
	String street=req.getParameter("street");
	int pincode=Integer.parseInt(req.getParameter("pincode"));
	String mobilenumber=req.getParameter("mobilenumber");
	
	Address a=new Address();
	a.setCountry(country);
	a.setState(state);
	a.setCity(city);
	a.setStreet(street);
	a.setPincode(pincode);
	
	
	
	user.setAddress(a);
	a.setUser(user);
	
	Account acc=new Account();
	acc.setUid(mobilenumber+"@falcon");
	acc.setMobilenumber(mobilenumber);
	
	user.setAccount(acc);
	acc.setUser(user);
	
	lservice.saveUser(user);
	return "index";
	
	
}

@GetMapping("/login")
public String showLoginForm(Model theModel) {

return "login";
}

@PostMapping("/loginUser")
public String loginUser(HttpServletRequest req,@ModelAttribute("user") User u1) {
	String email=req.getParameter("email");
	String pass=req.getParameter("password");
	String pass2=encryptPass(pass); //invokes encryptPass() method
	
	StringTokenizer st = new StringTokenizer(email, "@"); // breaks the email id based on '@' token
	String s2 = st.nextToken(); //email id without domain
	
	
	
	User d=lservice.findByEmail(email);//fetch records /object from table matching email id
	if(d==null) {
		
		return "register";	
	
	}
	
	
	else if(email.equals(d.getEmail()) && pass2.equals(d.getPassword()))
	{

	return "index";
	
     }
	return "index";
	
	
}

private String encryptPass(String pass) {
	Base64.Encoder encoder = Base64.getEncoder();
	String normalString = pass;
	String encodedString = encoder.encodeToString(
	normalString.getBytes(StandardCharsets.UTF_8) );
	return encodedString;
	}

	
	
	
}
