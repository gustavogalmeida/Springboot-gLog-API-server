package com.gproject.glog.domain.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gproject.glog.domain.exception.BusinessException;
import com.gproject.glog.domain.model.Client;
import com.gproject.glog.domain.repository.ClientRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClientService {

	private ClientRepository clientRepository;
	
	@Transactional
	public Client saveClient(Client client) {
		boolean emailInUse = clientRepository.findByEmail(client.getEmail())
				.stream().anyMatch(clientExist -> !clientExist.equals(client));
		
		if (emailInUse) {
			throw new BusinessException("Already existts a client whit this email.");
		}
		
		return clientRepository.save(client);
	}
	
	@Transactional
	public List<Client> listClient() {
		return clientRepository.findAll();
	}

	@Transactional
	public Client findClient (Long id) {

		return clientRepository.findById(id).orElseThrow();
	}
	
	@Transactional
	public void deleteClient(Long id) {
		
		if (!clientRepository.existsById(id)) {
			
		}
		
		clientRepository.deleteById(id);
	}
}
