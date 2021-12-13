package com.example.demo.dto.models;

import lombok.Data;

@Data
public class TicketDTO {
	
	private Integer clientID;
	private Integer tableNumero;
	private Integer[] metIDs;
	private Integer nbCouverts;

}
