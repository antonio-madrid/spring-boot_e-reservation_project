/**
 * 
 */
package com.platzi.ereservation.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * Represents Client's table
 * @author silex189
 *
 */
@Data
@Entity
@Table(name = "client")
@NamedQuery(name="Client.findByIdentification", query="SELECT c FROM Client c WHERE c.clientIdentification = ?1")
public class Client {
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid2")
	private String idClient;
	private String clientName;
	private String clientLastName;
	private String clientIdentification;
	private String clientAddress;
	private String clienPhoneNumber;
	private String clientEmail;
	@OneToMany(mappedBy = "client")
	private Set<Reservation> reservations;
	
	public Client() {
		// TODO Auto-generated constructor stub
	}
	
}
