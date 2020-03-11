package com.platzi.ereservation.view.resources.vo;

import java.util.Date;

import lombok.Data;

/**
 * class represents reservation table
 * @author silex189
 *
 */
@Data
public class ReservationVO {

	private String idReservation;
	private Date reservationCheckin;
	private Date reservationCheckout;
	private String reservationDescription;

}
