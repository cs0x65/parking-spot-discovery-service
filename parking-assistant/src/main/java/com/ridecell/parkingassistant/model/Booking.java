package com.ridecell.parkingassistant.model;

public class Booking {
	private long id;
	//can also be ParkingSpot object
	private long parkingSpotId;
	//can also be User object
	private long userId;
	//harcoded for now
	private int cost = 100;
	
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
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
}
