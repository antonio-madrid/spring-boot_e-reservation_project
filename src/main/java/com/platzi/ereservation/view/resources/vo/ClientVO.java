package com.platzi.ereservation.view.resources.vo;

import lombok.Data;

/**
 * Represents Client's table
 * @author silex189
 *
 */
@Data
public class ClientVO {

	private String idClient;
	private String clientName;
	private String clientLastName;
	private String clientIdentification;
	private String clientAddress;
	private String clienPhoneNumber;
	private String clientEmail;
	
}
