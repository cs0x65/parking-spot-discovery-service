package com.ridecell.parkingassistant.dto.adapter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ridecell.parkingassistant.dto.impl.ParkingSpotDTO;
import com.ridecell.parkingassistant.model.ParkingSpot;

public class ParkingSpotResponseDTOAdapter {
	public List<ParkingSpotDTO> buildResponse(List<ParkingSpot> list){
		List<ParkingSpotDTO> dtos = new ArrayList<>(list.size());
		for(Iterator<ParkingSpot> iterator = list.iterator(); iterator.hasNext(); ){
			ParkingSpot parkingSpot = iterator.next();
			ParkingSpotDTO dto = new ParkingSpotDTO();
			dto.setId(parkingSpot.getId());
			dto.setLatitude(parkingSpot.getLatitude());
			dto.setLongitude(parkingSpot.getLongitude());
			dto.setAddress(parkingSpot.getAddress());
			dtos.add(dto);
		}
		return dtos;
	}
}
