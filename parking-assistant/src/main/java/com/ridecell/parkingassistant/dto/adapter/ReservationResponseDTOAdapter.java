package com.ridecell.parkingassistant.dto.adapter;

import com.ridecell.parkingassistant.dto.impl.ReservationResponseDTO;
import com.ridecell.parkingassistant.model.Booking;

public class ReservationResponseDTOAdapter {
	public ReservationResponseDTO buildResponse(Booking booking){
		ReservationResponseDTO dto = new ReservationResponseDTO();
		dto.setId(booking.getId());
		dto.setParkingSpotId(booking.getParkingSpotId());
		dto.setCost(booking.getCost());
		return dto;
	}
}
