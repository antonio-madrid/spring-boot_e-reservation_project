/**
 * 
 */
package com.platzi.ereservation.business.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.platzi.ereservation.business.repository.ClientRepository;
import com.platzi.ereservation.model.Client;

/**
 * Class to define Client service
 * 
 * @author silex189
 *
 */
@Service
@Transactional(readOnly = true)
public class ClientService {
	private final ClientRepository clientRepository;

	public ClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	@Transactional
	public Client create(Client client) {
		return this.clientRepository.save(client);
	}

	@Transactional
	public Client update(Client client) {
		return this.clientRepository.save(client);
	}

	@Transactional
	public void delete(Client client) {
		this.clientRepository.delete(client);
	}

	public Client findByIdentification(String clientIdentification) {
		return this.clientRepository.findByIdentification(clientIdentification);
	}
}
