package com.ridecell.parkingassistant.restapi;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ridecell.parkingassistant.dto.impl.ReservationRequestDTO;

public interface BookingResource {
	public static final String RESOURCE_URI = "/bookings";
	public static final String CANCEL_REQUEST_URI = "/{bookingId}";
	
	/**
	 * 
	 * @param requestDTO that contains parking spot id to reserve. 
	 * @return booking id if successful else error json
	 *  
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response reserve(ReservationRequestDTO requestDTO);
	
	/**
	 * 
	 * @param requestDTO that contains parking spot id to reserve. 
	 * @return booking id if successful else error json
	 *  
	 */
	@Path(CANCEL_REQUEST_URI)
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response cancel(@PathParam("bookingId") String bookingId);
}
