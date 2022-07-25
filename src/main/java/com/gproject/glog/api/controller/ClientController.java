package com.gproject.glog.api.controller;

import java.util.List;

import javax.validation.Valid;

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
import com.gproject.glog.domain.services.ClientService;

@RequestMapping("/clients")
@RestController
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping
	public List<Client> list() {
		return clientService.listClient();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Client> find(@PathVariable("id") Long id) {		
		
		Client client = clientService.findClient(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(client);
		
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Client create(@Valid @RequestBody Client client) {
		
		return clientService.saveClient(client);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Client> update(@Valid @RequestBody Client client, @PathVariable("id") Long id) {
			
		client.setId(id);
		
		client = clientService.saveClient(client);
		
		return ResponseEntity.ok(client);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Client> delete (@PathVariable Long id){
		
		clientService.deleteClient(id);
		
		return ResponseEntity.noContent().build();
		
	}
}
