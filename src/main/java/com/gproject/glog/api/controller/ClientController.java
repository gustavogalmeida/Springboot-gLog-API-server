package com.gproject.glog.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gproject.glog.domain.model.Client;
import com.gproject.glog.domain.repository.ClientRepository;

@RequestMapping("/clients")
@RestController
public class ClientController {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@GetMapping
	public List<Client> list() {
		return clientRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Client> find(@PathVariable("id") Long id) {
		
		return clientRepository.findById(id).map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
		
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Client create(@RequestBody Client client) {
		
		return clientRepository.save(client);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Client> update(@RequestBody Client client, @PathVariable("id") Long id) {
		if (!clientRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		client.setId(id);
		
		client = clientRepository.save(client);
		
		return ResponseEntity.ok(client);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Client> delete (@PathVariable Long id){
		if (!clientRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		clientRepository.deleteById(id);		
		return ResponseEntity.noContent().build();
	}
}
