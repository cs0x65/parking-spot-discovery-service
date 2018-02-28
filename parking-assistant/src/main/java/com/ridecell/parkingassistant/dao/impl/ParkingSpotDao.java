/**
 * parshwabhoomi-server	01-Dec-2017:10:20:33 PM
 */
package com.ridecell.parkingassistant.dao.impl;

import java.util.List;

import com.ridecell.parkingassistant.model.ParkingSpot;


/**
 * @author Saurabh
 * git: champasheru saurabh.cse2@gmail.com
 *
 */
public interface ParkingSpotDao {
	public List<ParkingSpot> getAll();
	
	public List<ParkingSpot> getAvailable();
	
	public List<ParkingSpot> getReserved();
}
