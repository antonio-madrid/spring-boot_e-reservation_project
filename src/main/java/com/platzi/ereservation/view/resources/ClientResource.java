/**
 * 
 */
package com.platzi.ereservation.view.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.platzi.ereservation.business.services.ClientService;
import com.platzi.ereservation.model.Client;
import com.platzi.ereservation.view.resources.vo.ClientVO;

/**
 * @author silex189
 *
 */
@RestController
@RequestMapping("/api/client")
public class ClientResource {

	private final ClientService clientService;
	
	public ClientResource(ClientService clientService) {
		this.clientService = clientService;
	}
	
	@PostMapping
	public ResponseEntity<Client> createClient(RequestBody ClientVO clientVO) {
		Client client = new Client();
		
		client.setClientName(clientVO.getClientName());
		client.setClientLastName(clientVO.getClientLastName());
		client.setClientAddress(clientVO.getClientAddress());
		client.setClienPhoneNumber(clientVO.getClienPhoneNumber());
		client.setClientEmail(clientVO.getClientEmail());
		
		return new ResponseEntity<>(this.clientService.create(client), HttpStatus.CREATED);
	}

}
