/**
 * parshwabhoomi-server	03-Dec-2017:1:42:02 PM
 */
package com.ridecell.parkingassistant.dto.impl;

import com.ridecell.parkingassistant.dto.AbstractRequestDTO;

/**
 * @author Saurabh
 * git: champasheru saurabh.cse2@gmail.com
 *
 */
public class SearchRequestDTO extends AbstractRequestDTO {
	private float latitude;
	private float longitude;
	private float radius;
	
	/**
	 * @return the latitude
	 */
	public float getLatitude() {
		return latitude;
	}
	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	/**
	 * @return the longitude
	 */
	public float getLongitude() {
		return longitude;
	}
	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	/**
	 * @return the query
	 */
	public float getRadius() {
		return radius;
	}
	/**
	 * @param query the query to set
	 */
	public void setRadius(float radius) {
		this.radius = radius;
	}
}
