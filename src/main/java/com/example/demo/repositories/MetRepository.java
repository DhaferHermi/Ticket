package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.MetEntity;


public interface MetRepository extends JpaRepository<MetEntity, Integer> {

}
