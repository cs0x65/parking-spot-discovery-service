package com.ridecell.parkingassistant.dto;

//DTO to send response on new resource creation. Corresponding
//status code is 201
public class CreateResourceResponseDTO extends AbstractResponseDTO {

	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "CreateEntityDTO [id=" + id + "]";
	}
		
	
}
