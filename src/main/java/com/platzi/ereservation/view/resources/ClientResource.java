/**
 * 
 */
package com.platzi.ereservation.view.resources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.platzi.ereservation.business.services.ClientService;
import com.platzi.ereservation.model.Client;
import com.platzi.ereservation.view.resources.vo.ClientVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author silex189
 *
 */
@RestController
@RequestMapping("/api/client")
@Api(tags = "client")
public class ClientResource {

	private final ClientService clientService;

	public ClientResource(ClientService clientService) {
		this.clientService = clientService;
	}

	@PostMapping
	@ApiOperation(value = "Create a client", notes = "Service to create a new Client")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Client created successfully"),
			@ApiResponse(code = 400, message = "Invalid request")})
	public ResponseEntity<Client> createClient(@RequestBody ClientVO clientVO) {
		Client client = new Client();

		client.setClientName(clientVO.getClientName());
		client.setClientLastName(clientVO.getClientLastName());
		client.setClientAddress(clientVO.getClientAddress());
		client.setClienPhoneNumber(clientVO.getClienPhoneNumber());
		client.setClientEmail(clientVO.getClientEmail());

		return new ResponseEntity<>(this.clientService.create(client), HttpStatus.CREATED);
	}

	@PutMapping("/¨{identification}")
	@ApiOperation(value = "Update a client", notes = "Service to update a Client")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Client updated successfully"),
			@ApiResponse(code = 404, message = "Client not found")})
	public ResponseEntity<Client> updateClient(@PathVariable("identification") String identification,
			ClientVO clientVO) {

		Client client = this.clientService.findByIdentification(identification);

		if (client == null) {
			return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
		} else {
			client.setClientName(clientVO.getClientName());
			client.setClientLastName(clientVO.getClientLastName());
			client.setClientAddress(clientVO.getClientAddress());
			client.setClienPhoneNumber(clientVO.getClienPhoneNumber());
			client.setClientEmail(clientVO.getClientEmail());
		}
		return new ResponseEntity<>(this.clientService.update(client), HttpStatus.OK);
	}
	
	@DeleteMapping("/{identification}")
	@ApiOperation(value = "Delete a client", notes = "Service to delete a Client")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Client delete successfully"),
			@ApiResponse(code = 404, message = "Client not found")})
	public void removeClient(@PathVariable("identification") String identification) {
		Client client = this.clientService.findByIdentification(identification);
		
		if (client != null) {
			this.clientService.delete(client);
		}
	}
	
	@GetMapping
	@ApiOperation(value = "List a clients", notes = "Service to list Clients")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Clients found successfully"),
			@ApiResponse(code = 404, message = "Clients not found")})
	public ResponseEntity<List<Client>> findAll() {
		return ResponseEntity.ok(this.clientService.findAll());
	}
}
