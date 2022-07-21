package com.gproject.glog.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gproject.glog.domain.model.Client;

@RestController
public class ClientController {
	
	@GetMapping(value = "/clients")
	public List<Client> list() {
		var client1 = new Client();
		client1.setId(1L);
		client1.setEmail("gustavogalvesalmeida@gmail.com");
		client1.setName("Gustavo Almeida");
		client1.setPhoneNumber("34 99999 9999");
		
		var client2 = new Client();
		client2.setId(2L);
		client2.setName("Pedro1");
		client2.setEmail("pedro@gmail.com");
		client2.setPhoneNumber("34 98888 8888");
		
		return Arrays.asList(client1, client2);
	}
	
}
