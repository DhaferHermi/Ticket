package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.models.ClientRequestDTO;
import com.example.demo.dto.models.ClientResponseDTO;
import com.example.demo.services.ClientService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ClientController {
 private ClientService clientService;
 
 @PostMapping("/api/clients")
 public ClientResponseDTO addClient(@Valid  @RequestBody ClientRequestDTO clientRequestDTO) {
	 return clientService.saveToDB (clientRequestDTO);
 }
}
