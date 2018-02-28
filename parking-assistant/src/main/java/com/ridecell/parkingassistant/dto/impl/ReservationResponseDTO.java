package com.ridecell.parkingassistant.dto.impl;

import com.ridecell.parkingassistant.dto.AbstractResponseDTO;

public class ReservationResponseDTO extends AbstractResponseDTO {
	private long id;
	private long parkingSpotId;
	private int cost;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getParkingSpotId() {
		return parkingSpotId;
	}
	public void setParkingSpotId(long parkingSpotId) {
		this.parkingSpotId = parkingSpotId;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
}
