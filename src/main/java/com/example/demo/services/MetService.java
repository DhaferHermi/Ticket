package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.demo.dto.models.MetDTO;
import com.example.demo.entities.Dessert;
import com.example.demo.entities.Entree;
import com.example.demo.entities.MetEntity;
import com.example.demo.entities.Plat;
import com.example.demo.repositories.MetRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MetService {
	private MetRepository metRepository;
	ModelMapper mapper = new ModelMapper();
	
	public MetDTO saveMetInDB(MetDTO dto) {
		
		 MetEntity metEntity =  null;
		 
		 switch (dto.getType()) {
			case "Plat":
				metEntity = mapper.map(dto, Plat.class);
				break;
			case "Entree":
				metEntity = mapper.map(dto, Entree.class);
				break;
			case "Dessert":
				metEntity = mapper.map(dto, Dessert.class);
				break;
		}
		
		 metEntity = metRepository.save(metEntity);
		 dto.setId(metEntity.getId());
		 
		return dto;
	} 
	
	public List<MetDTO> getAllMet() {
//		List<MetEntity> entities = metRepository.findAll();
//		List<MetDTO> dtos = new ArrayList<>();
//		for(MetEntity metEntity : entities) {
//			MetDTO dto = mapper.map(metEntity, MetDTO.class);
//			dto.setType(metEntity.getClass().getSimpleName());
//			dtos.add(dto);
//		}
		return metRepository.findAll().stream()
				.map((MetEntity entity) -> {
					MetDTO dto = mapper.map(entity, MetDTO.class);
					dto.setType(entity.getClass().getSimpleName());
					return dto;
				}).collect(Collectors.toList());
		
	}
}
