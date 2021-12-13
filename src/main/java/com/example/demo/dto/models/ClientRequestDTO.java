package com.example.demo.dto.models;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NonNull;

@Data
public class ClientRequestDTO {

	@NotBlank
	@Size(min=3, max = 50)
	private String nom;
	private String prenom;
	@Past
	private LocalDate dateDeNaissance;
	@Email
	private String courrier;
	private String telephone;
	
}
