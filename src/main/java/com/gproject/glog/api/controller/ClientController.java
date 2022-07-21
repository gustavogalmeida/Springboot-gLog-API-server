package com.gproject.glog.api.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gproject.glog.domain.model.Client;

@RestController
public class ClientController {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@GetMapping("/clients")
	public List<Client> list() {
		return entityManager.createQuery("from Client", Client.class).getResultList();
	}
	
}
