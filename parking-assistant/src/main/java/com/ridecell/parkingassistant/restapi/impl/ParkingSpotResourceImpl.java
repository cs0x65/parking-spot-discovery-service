package com.ridecell.parkingassistant.restapi.impl;

import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.logging.log4j.LogManager;

import com.ridecell.parkingassistant.AppContext;
import com.ridecell.parkingassistant.core.Geofencer;
import com.ridecell.parkingassistant.dao.impl.ParkingSpotDaoImpl;
import com.ridecell.parkingassistant.dto.ErrorResponseDTO;
import com.ridecell.parkingassistant.dto.ErrorResponseDTO.HTTP_STATUS_CODE;
import com.ridecell.parkingassistant.dto.adapter.ParkingSpotResponseDTOAdapter;
import com.ridecell.parkingassistant.dto.impl.ParkingSpotDTO;
import com.ridecell.parkingassistant.dto.impl.SearchRequestDTO;
import com.ridecell.parkingassistant.model.ParkingSpot;
import com.ridecell.parkingassistant.restapi.ParkingSpotResource;
import com.ridecell.parkingassistant.utils.RestUtils;

@Path(ParkingSpotResource.RESOURCE_URI)
public class ParkingSpotResourceImpl implements ParkingSpotResource {

	@Override
	public Response getAll() {
		LogManager.getLogger().info("Retrieving all parking spots...");
		
		Response response = null;
		ParkingSpotDaoImpl parkingSpotDaoImpl = null;
		try{
			parkingSpotDaoImpl = (ParkingSpotDaoImpl)AppContext.getDefaultContext().getDaoProvider().getDAO("ParkingSpotDaoImpl");
			List<ParkingSpot> spots = parkingSpotDaoImpl.getAll();
			ParkingSpotResponseDTOAdapter responseDTOAdapter = new ParkingSpotResponseDTOAdapter();
			List<ParkingSpotDTO> dtos = responseDTOAdapter.buildResponse(spots);
			GenericEntity<List<ParkingSpotDTO>> gsr = new GenericEntity<List<ParkingSpotDTO>>(dtos){};
			response = Response.ok(gsr).build();
		}catch(Exception e){
			ErrorResponseDTO errorResponseDTO = RestUtils.createErrorResponseDTO(HTTP_STATUS_CODE.INTERNAL_SERVER_ERROR, "Couldn't serve results! Please try again.");
			response = Response.status(Status.INTERNAL_SERVER_ERROR).entity(errorResponseDTO).build();
			LogManager.getLogger().error("Couldn't serve results!", e);
		}
		
		return response;
	}

	@Override
	public Response getAvailable() {
		LogManager.getLogger().info("Retrieving available parking spots...");
		
		Response response = null;
		ParkingSpotDaoImpl parkingSpotDaoImpl = null;
		try{
			parkingSpotDaoImpl = (ParkingSpotDaoImpl)AppContext.getDefaultContext().getDaoProvider().getDAO("ParkingSpotDaoImpl");
			List<ParkingSpot> spots = parkingSpotDaoImpl.getAvailable();
			ParkingSpotResponseDTOAdapter responseDTOAdapter = new ParkingSpotResponseDTOAdapter();
			List<ParkingSpotDTO> dtos = responseDTOAdapter.buildResponse(spots);
			GenericEntity<List<ParkingSpotDTO>> gsr = new GenericEntity<List<ParkingSpotDTO>>(dtos){};
			response = Response.ok(gsr).build();
		}catch(Exception e){
			ErrorResponseDTO errorResponseDTO = RestUtils.createErrorResponseDTO(HTTP_STATUS_CODE.INTERNAL_SERVER_ERROR, "Couldn't serve results! Please try again.");
			response = Response.status(Status.INTERNAL_SERVER_ERROR).entity(errorResponseDTO).build();
			LogManager.getLogger().error("Couldn't serve results!", e);
		}
		
		return response;
	}

	@Override
	public Response getReserved() {
		LogManager.getLogger().info("Retrieving reserved parking spots...");
		
		Response response = null;
		ParkingSpotDaoImpl parkingSpotDaoImpl = null;
		try{
			parkingSpotDaoImpl = (ParkingSpotDaoImpl)AppContext.getDefaultContext().getDaoProvider().getDAO("ParkingSpotDaoImpl");
			List<ParkingSpot> spots = parkingSpotDaoImpl.getReserved();
			ParkingSpotResponseDTOAdapter responseDTOAdapter = new ParkingSpotResponseDTOAdapter();
			List<ParkingSpotDTO> dtos = responseDTOAdapter.buildResponse(spots);
			GenericEntity<List<ParkingSpotDTO>> gsr = new GenericEntity<List<ParkingSpotDTO>>(dtos){};
			response = Response.ok(gsr).build();
		}catch(Exception e){
			ErrorResponseDTO errorResponseDTO = RestUtils.createErrorResponseDTO(HTTP_STATUS_CODE.INTERNAL_SERVER_ERROR, "Couldn't serve results! Please try again.");
			response = Response.status(Status.INTERNAL_SERVER_ERROR).entity(errorResponseDTO).build();
			LogManager.getLogger().error("Couldn't serve results!", e);
		}
		
		return response;
	}

	@Override
	public Response search(SearchRequestDTO requestDTO) {
		LogManager.getLogger().info("Retrieving all parking spots...");
		
		Response response = null;
		ParkingSpotDaoImpl parkingSpotDaoImpl = null;
		try{
			parkingSpotDaoImpl = (ParkingSpotDaoImpl)AppContext.getDefaultContext().getDaoProvider().getDAO("ParkingSpotDaoImpl");
			List<ParkingSpot> spots = parkingSpotDaoImpl.getAll();
			ParkingSpotResponseDTOAdapter responseDTOAdapter = new ParkingSpotResponseDTOAdapter();
			//Note that we could have done this using something like PostGIS as well where we can directly find
			//if given PoS falls within Z radius from geometry(x,y). But for assigment purpose using haversine formulae to find out distance.
			Geofencer geofencer = new Geofencer(requestDTO.getLatitude(), requestDTO.getLongitude(), requestDTO.getRadius());
			spots = geofencer.findWithinFence(spots);
			List<ParkingSpotDTO> dtos = responseDTOAdapter.buildResponse(spots);
			GenericEntity<List<ParkingSpotDTO>> gsr = new GenericEntity<List<ParkingSpotDTO>>(dtos){};
			response = Response.ok(gsr).build();
		}catch(Exception e){
			ErrorResponseDTO errorResponseDTO = RestUtils.createErrorResponseDTO(HTTP_STATUS_CODE.INTERNAL_SERVER_ERROR, "Couldn't serve results! Please try again.");
			response = Response.status(Status.INTERNAL_SERVER_ERROR).entity(errorResponseDTO).build();
			LogManager.getLogger().error("Couldn't serve results!", e);
		}
		
		return response;
	}

}
