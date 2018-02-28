package com.ridecell.parkingassistant.dao.impl;

import com.ridecell.parkingassistant.model.Booking;

public interface BookingDao {
	public Booking reserve(Booking booking);
	
	public void cancel(long bookingId);
}
