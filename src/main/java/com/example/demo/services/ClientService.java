package com.example.demo.services;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.demo.dto.models.ClientRequestDTO;
import com.example.demo.dto.models.ClientResponseDTO;
import com.example.demo.entities.ClientEntity;
import com.example.demo.repositories.ClientRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClientService {
	private ClientRepository clientRepository;

	public ClientResponseDTO saveToDB(ClientRequestDTO clientRequestDTO) {
		ModelMapper mapper = new ModelMapper();
		
		ClientEntity clientEntity = mapper.map(clientRequestDTO, ClientEntity.class);
		
		//ClientEntity clientEntity = new ClientEntity();
		//clientEntity.setNom(clientRequestDTO.getNom());
		//clientEntity.setCourrier(clientRequestDTO.getCourrier());
		//clientEntity.setDateDeNaissance(clientRequestDTO.getDateDeNaissance());
		//clientEntity.setPrenom(clientRequestDTO.getPrenom());
		//clientEntity.setTelephone(clientRequestDTO.getTelephone());
		
		clientRepository.save(clientEntity);
		
		ClientResponseDTO clientResponseDTO = mapper.map(clientEntity, ClientResponseDTO.class);
		
//		ClientResponseDTO clientResponseDTO = new ClientResponseDTO();
//		clientResponseDTO.setId(clientEntity.getId());
//		clientResponseDTO.setNomComplet(clientEntity.getNom()+" "+clientEntity.getPrenom());
//		clientResponseDTO.setAge((int)ChronoUnit.YEARS.between(clientEntity.getDateDeNaissance(), LocalDate.now()) );
		
		return clientResponseDTO;
		
		
	} 
}
