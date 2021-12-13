package com.example.demo.services;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Table;

import org.springframework.stereotype.Service;

import com.example.demo.dto.models.TicketDTO;
import com.example.demo.entities.ClientEntity;
import com.example.demo.entities.MetEntity;
import com.example.demo.entities.TableEntity;
import com.example.demo.entities.TicketEntity;
import com.example.demo.repositories.ClientRepository;
import com.example.demo.repositories.MetRepository;
import com.example.demo.repositories.TableRepository;
import com.example.demo.repositories.TicketRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TicketService {
	private ClientRepository clientRepository;
	private TableRepository tableRepository;
	private MetRepository metRepository;
	private TicketRepository ticketRepository;
	
	public double createTicket(TicketDTO ticketDTO) {
		ClientEntity clientEntity = clientRepository.findById(ticketDTO.getClientID()).get();
		TableEntity table = tableRepository.findById(ticketDTO.getTableNumero()).get();
		List<MetEntity> mets = metRepository.findAllById(Arrays.asList(ticketDTO.getMetIDs()));
		
		double addition = mets.stream()
				.mapToDouble(met -> met.getPrix())
				.sum()+table.getSupplements();
		
		TicketEntity ticketEntity = new TicketEntity();
		ticketEntity.setClient(clientEntity);
		ticketEntity.setTable(table);
		ticketEntity.setMets(mets);
		ticketEntity.setNbCouverts(ticketDTO.getNbCouverts());
		ticketEntity.setAddition(addition);
		ticketEntity.setDateTime(LocalDateTime.now());
		ticketRepository.save(ticketEntity);
		
		return addition;
 		
	}

}
