package com.coforge.project.obs.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coforge.project.obs.model.Passbook;
import com.coforge.project.obs.repository.PassbookRepository;

@Service
@Transactional

public class PassbookService {

	@Autowired
	public PassbookRepository pRepo;
	
	
	public List<Passbook> listall(){
		return pRepo.findAll();
	}
	
	public Passbook savedata(Passbook passbook) { // save is userdefined
		
		return pRepo.save(passbook); // save method defined in JPA repo
		}
	
	public Passbook get(Long id) {
		return pRepo.findById(id).get(); // defined in JPA repo
		}
	

	
}
