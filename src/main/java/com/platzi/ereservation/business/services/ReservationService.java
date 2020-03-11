/**
 * 
 */
package com.platzi.ereservation.business.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.platzi.ereservation.business.repository.ReservationsRepository;
import com.platzi.ereservation.model.Reservation;

/**
 * @author antonio.jimenez
 *
 */
@Service
public class ReservationService {
	private final ReservationsRepository reservationsRepository;
	
	public ReservationService(ReservationsRepository reservationsRepository) {
		this.reservationsRepository = reservationsRepository;
	}
	
	@Transactional
	public Reservation create(Reservation reservation) {
		return this.reservationsRepository.save(reservation);
	}
	
	@Transactional
	public Reservation update(Reservation reservation) {
		return this.reservationsRepository.save(reservation);
	}
	
	@Transactional
	public void delete(Reservation reservation) {
		this.reservationsRepository.delete(reservation);
	}
	
	public Reservation findByIdReservation(String idReservation) {
		return this.reservationsRepository.findByIdReservation(idReservation);
	}
	
	public List<Reservation> findAll() {
		return this.reservationsRepository.findAll();
	}
	
}
