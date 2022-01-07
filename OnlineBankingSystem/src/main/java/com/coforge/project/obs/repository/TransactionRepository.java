package com.coforge.project.obs.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.coforge.project.obs.model.Transact;


@Repository
public interface TransactionRepository extends JpaRepository<Transact,Long>{

	
	 @Query("SELECT new com.coforge.project.obs.model.Transact(t.uid,t.date,t.recieverid,t.Sent,t.recieved,t.balance) FROM Transact t WHERE t.uid = :id OR t.recieverid = :id")
	    public List<Transact> getAllTxn(@Param("id") String id);
	
	
	
}
