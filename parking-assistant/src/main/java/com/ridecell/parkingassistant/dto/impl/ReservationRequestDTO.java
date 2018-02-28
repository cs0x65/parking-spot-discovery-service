package com.ridecell.parkingassistant.dto.impl;

import com.ridecell.parkingassistant.dto.AbstractRequestDTO;

public class ReservationRequestDTO extends AbstractRequestDTO {
	private long parkingSpotId;
	private long userId;

	public long getParkingSpotId() {
		return parkingSpotId;
	}

	public void setParkingSpotId(long parlkingSpotId) {
		this.parkingSpotId = parlkingSpotId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	
}
