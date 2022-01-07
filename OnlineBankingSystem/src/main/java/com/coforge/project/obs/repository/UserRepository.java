package com.coforge.project.obs.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.coforge.project.obs.model.Account;
import com.coforge.project.obs.model.User;
import com.coforge.project.obs.model.UserAddressAccount;

public interface UserRepository extends JpaRepository<User,Long> {

	public User findByEmail(String email);
	
	@Query("select new com.coforge.project.obs.model.UserAddressAccount(u.id,u.email,u.firstname,u.lastname,u.fathername,"
			+ "u.dob,u.aadharnumber,u.pannumber,u.password,u.mobilenumber,"
			+ "a.country,a.state,a.city,a.street,a.pincode,acc.uid) from User u Inner Join u.address a Inner Join u.account acc")
		
	public List<UserAddressAccount> fetchUserInnerJoin();
	
	public  Optional<User> findItByEmail(String email);

	@Query("SELECT new com.coforge.project.obs.model.Account(a.mobilenumber,a.uid) FROM Account a WHERE a.uid = :id")
    public List<Account> checkAccount(@Param("id") String id);
	
	
}