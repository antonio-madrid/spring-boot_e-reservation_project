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

import com.platzi.ereservation.business.services.ReservationService;
import com.platzi.ereservation.model.Reservation;
import com.platzi.ereservation.view.resources.vo.ReservationVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author antonio.jimenez
 *
 */
@RestController
@RequestMapping("/api/reservation")
@Api(tags = "reservation")
public class ReservationResource {
	
	private ReservationService reservationService;
	
	@PostMapping
	@ApiOperation(value = "Create a Reservation", notes = "Service to create a Reservation")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Reservation created successfully"),
			@ApiResponse(code = 400, message = "Invalid request") })
	public ResponseEntity<Reservation> createReservation(@RequestBody ReservationVO reservationVO) {
		Reservation reservation = new Reservation();
		
		reservation.setReservationCheckin(reservationVO.getReservationCheckin());
		reservation.setReservationCheckout(reservationVO.getReservationCheckout());
		
		return new ResponseEntity<Reservation>(reservationService.create(reservation), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value = "Update a reservation", notes = "Service to update a Reservation")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Reservation updated successfully"),
			@ApiResponse(code = 404, message = "Reservation not found")	})
	public ResponseEntity<Reservation> updateReservation(@PathVariable("id") String id, 
			@RequestBody ReservationVO reservationVO) {
		Reservation reservation = reservationService.findByIdReservation(id);
		
		if ( reservation == null) 
			return new ResponseEntity<Reservation>(HttpStatus.NOT_FOUND);
		
		reservation.setReservationCheckin(reservationVO.getReservationCheckin());
		reservation.setReservationCheckout(reservationVO.getReservationCheckout());
		
		return new ResponseEntity<Reservation>(reservationService.update(reservation), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Delete a Reservation", notes = "Service to delete a Reservation")
	@ApiResponses(value = {
			@ApiResponse(code = 204, message = "Reservation deleted successfully"),
			@ApiResponse(code = 404, message = "Reservation not found")	})
	public void deleteReservation(@PathVariable("id") String id) {
		Reservation reservation = reservationService.findByIdReservation(id);
		
		if ( reservation != null )
			reservationService.delete(reservation);
	}
	
	@GetMapping
	@ApiOperation(value = "List reservations", notes = "service to list reservations")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Reservations found successfully"),
			@ApiResponse(code = 404, message = "Reservations not found") })
	public ResponseEntity<List<Reservation>> findAll() {
		return ResponseEntity.ok(reservationService.findAll());
	}

}
