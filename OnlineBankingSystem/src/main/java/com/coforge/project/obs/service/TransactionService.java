package com.coforge.project.obs.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coforge.project.obs.model.Transact;
import com.coforge.project.obs.repository.TransactionRepository;

@Service
@Transactional
public class TransactionService {

	@Autowired
	public TransactionRepository tRepo;
	
	public Transact savetxn(Transact txn1) {
		
	 return tRepo.save(txn1);
	}
	
	
public Transact getlasttxn(String uid) {
		
		List<Transact> list=tRepo.getAllTxn(uid);
		Transact t=list.get(list.size() - 1);
		return t;
	}
	
	
	public List<Transact> getalltxn(String uid){
		
		return tRepo.getAllTxn(uid);
	}
	
	
	
}