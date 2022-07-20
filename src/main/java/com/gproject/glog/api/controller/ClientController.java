package com.gproject.glog.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
	
	@GetMapping(value = "/clients")
	public String list() {
		return "String test";
	}
	
}
