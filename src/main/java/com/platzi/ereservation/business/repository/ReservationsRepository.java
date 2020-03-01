/**
 * 
 */
package com.platzi.ereservation.business.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.platzi.ereservation.model.Reservation;

/**
 * @author silex189
 *
 */
public interface ReservationsRepository extends JpaRepository<Reservation, String>{
	
	@Query("Select r from Reservation r where r.reservationCheckin =:checkin and r.reservationCheckout =:checkout")
	public List<Reservation> find(@Param("checkin")Date checkin, @Param("checkout")Date checkout);

}
