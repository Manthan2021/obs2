package com.coforge.project.obs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.project.obs.model.Passbook;
import com.coforge.project.obs.repository.PassbookRepository;
import com.coforge.project.obs.service.PassbookService;

@RestController

public class PassbookController {

	@Autowired
	private PassbookService pService;
	
	@Autowired
	private PassbookRepository pRepo;
	
	
	
	@GetMapping("/txn/{id}")
	public ResponseEntity<Passbook> gettxn(@PathVariable Long id){
		return new ResponseEntity<>(pService.get(id),HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Passbook> > gettxn(Passbook passbook){
		return new ResponseEntity<>(pService.listall(),HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Passbook> savetxn(@RequestBody Passbook passbook){
		return new ResponseEntity<>(pService.savedata(passbook),HttpStatus.OK);
	}
	
}
