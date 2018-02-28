package com.ridecell.parkingassistant.restapi.impl;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.logging.log4j.LogManager;

import com.ridecell.parkingassistant.AppContext;
import com.ridecell.parkingassistant.dao.impl.BookingDaoImpl;
import com.ridecell.parkingassistant.dto.ErrorResponseDTO;
import com.ridecell.parkingassistant.dto.ErrorResponseDTO.HTTP_STATUS_CODE;
import com.ridecell.parkingassistant.dto.adapter.ReservationRequestDTOAdapter;
import com.ridecell.parkingassistant.dto.adapter.ReservationResponseDTOAdapter;
import com.ridecell.parkingassistant.dto.impl.ReservationRequestDTO;
import com.ridecell.parkingassistant.dto.impl.ReservationResponseDTO;
import com.ridecell.parkingassistant.model.Booking;
import com.ridecell.parkingassistant.restapi.BookingResource;
import com.ridecell.parkingassistant.utils.RestUtils;

@Path(BookingResource.RESOURCE_URI)
public class BookingResourceImpl implements BookingResource {

	@Override
	public Response reserve(ReservationRequestDTO requestDTO) {
		LogManager.getLogger().info("Reserving a parking spot...");
		
		Response response = null;
		BookingDaoImpl bookingDaoImpl = null;
		try{
			bookingDaoImpl = (BookingDaoImpl)AppContext.getDefaultContext().getDaoProvider().getDAO("BookingDaoImpl");
			ReservationRequestDTOAdapter requestDTOAdapter = new ReservationRequestDTOAdapter();
			Booking booking = requestDTOAdapter.buildRequest(requestDTO);
			//get updated booking with id
			booking = bookingDaoImpl.reserve(booking);
			ReservationResponseDTOAdapter responseDTOAdapter = new ReservationResponseDTOAdapter();
			ReservationResponseDTO responseDTO = responseDTOAdapter.buildResponse(booking);
			response = Response.status(Status.CREATED).entity(responseDTO).build();
		}catch(Exception e){
			ErrorResponseDTO errorResponseDTO = RestUtils.createErrorResponseDTO(HTTP_STATUS_CODE.INTERNAL_SERVER_ERROR, "Couldn't fulfill request! Please try again.");
			response = Response.status(Status.INTERNAL_SERVER_ERROR).entity(errorResponseDTO).build();
			LogManager.getLogger().error("Couldn't fulfill results!", e);
		}
		
		return response;
	}

	@Override
	public Response cancel(String bookingId) {
		LogManager.getLogger().info("Reserving a parking spot...");
		
		Response response = null;
		BookingDaoImpl bookingDaoImpl = null;
		try{
			bookingDaoImpl = (BookingDaoImpl)AppContext.getDefaultContext().getDaoProvider().getDAO("BookingDaoImpl");
			bookingDaoImpl.cancel(Long.parseLong(bookingId));
			response = Response.ok().build();
		}catch(Exception e){
			ErrorResponseDTO errorResponseDTO = RestUtils.createErrorResponseDTO(HTTP_STATUS_CODE.INTERNAL_SERVER_ERROR, "Couldn't fulfill request! Please try again.");
			response = Response.status(Status.INTERNAL_SERVER_ERROR).entity(errorResponseDTO).build();
			LogManager.getLogger().error("Couldn't fulfill results!", e);
		}
		
		return response;
	}
}
