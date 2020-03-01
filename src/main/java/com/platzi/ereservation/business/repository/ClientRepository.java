/**
 * 
 */
package com.platzi.ereservation.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.platzi.ereservation.model.Client;

/**
 * Interface defines DB operations related with client (DAO's)
 * @author silex189
 *
 */
public interface ClientRepository extends JpaRepository<Client, String>{

	/**
	 * Method definition to find clients by their last name
	 * @param clientLastName
	 * @return
	 */
	public Client findByClientLastName(String clientLastName);
	
	public Client findByIdentification(String clientIdentification);
	
	
}
