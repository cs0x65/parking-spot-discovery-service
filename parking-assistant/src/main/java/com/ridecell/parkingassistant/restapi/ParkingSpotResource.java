package com.ridecell.parkingassistant.restapi;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ridecell.parkingassistant.dto.impl.SearchRequestDTO;


public interface ParkingSpotResource {
	public static final String RESOURCE_URI = "/parkings";
	public static final String SEARCH_REQUEST_URI = "/search";
	public static final String RESERVED_REQUEST_URI = "/reserved";
	public static final String AVAILABLE_REQUEST_URI = "/available";
	
	/**
	 * 
	 * @return all parking spots - i.e both reserved and available
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll();
	
	/**
	 * 
	 * @return all available parking spots
	 */
	@GET
	@Path(AVAILABLE_REQUEST_URI)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAvailable();
	
	/**
	 * 
	 * @return all reserved parking spots
	 */
	@GET
	@Path(RESERVED_REQUEST_URI)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getReserved();
	
	/**
	 * 
	 * @param requestDTO that contains lat, long and radius 
	 * @return all the parking spots in the given area with lat, long as center and in given radius
	 *  
	 */
	@Path(SEARCH_REQUEST_URI)
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response search(SearchRequestDTO requestDTO);
}
