package com.gproject.glog.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.gproject.glog.domain.model.Client;
import com.gproject.glog.domain.repository.ClientRepository;

@RestController
public class ClientController {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@GetMapping("/clients")
	public List<Client> list() {
		return clientRepository.findAll();
	}
	
	@GetMapping("/clients/{id}")
	public ResponseEntity<Client> find(@PathVariable("id") Long id) {
		
		Optional<Client> client = clientRepository.findById(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(client.orElse(null));
	}
	
}
