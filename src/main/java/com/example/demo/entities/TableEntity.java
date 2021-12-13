package com.example.demo.entities;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@javax.persistence.Table(name = "tableRest")
public class TableEntity {  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numero;
	
	private int nbCouverts;
	@Enumerated(EnumType.STRING)
	private TableType type;
	
	private double supplements;

}
