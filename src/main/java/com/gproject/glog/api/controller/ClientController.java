package com.gproject.glog.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gproject.glog.domain.model.Client;

@RestController
public class ClientController {
	
	@GetMapping(value = "/clients")
	public ResponseEntity<Client> list() {
		Client client1 = new Client();
		client1.setId(1L);
		client1.setEmail("gustavogalvesalmeida@gmail.com");
		client1.setName("Gustavo Almeida");
		client1.setPhoneNumber("3499999999");
		
		return ResponseEntity.status(HttpStatus.OK).body(client1);
	}
	
}
