package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.models.MetDTO;
import com.example.demo.services.MetService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class MetController {
	
	private MetService metService;
	
	@PostMapping("/api/mets")
	public MetDTO saveDTO(@RequestBody MetDTO dto) {
		return metService.saveMetInDB(dto);
	}
	
	@GetMapping("/api/mets")
	public List<MetDTO> getAllDTO(){
		return metService.getAllMet();
	}

}
