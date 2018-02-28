package com.ridecell.parkingassistant.dto.adapter;

import com.ridecell.parkingassistant.dto.impl.ReservationRequestDTO;
import com.ridecell.parkingassistant.model.Booking;

public class ReservationRequestDTOAdapter {
	public Booking buildRequest(ReservationRequestDTO dto){
		Booking booking = new Booking();
		booking.setParkingSpotId(dto.getParkingSpotId());
		booking.setUserId(dto.getUserId());
		return booking;
	}
}
