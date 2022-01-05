package com.coforge.project.obs.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.coforge.project.obs.model.Transact;


@Repository
public interface TransactionRepository extends JpaRepository<Transact,Long>{

	
	@Query("select new com.coforge.project.obs.model.Transact(t.uid,t.date,t.recieverid,"
			+ "t.Sent,t.recieved,t.balance)from Transact t where t.uid=uid OR t.recieverid=uid") 
	
			public List<Transact> getAllTxn(String uid);
	
	

	
}
