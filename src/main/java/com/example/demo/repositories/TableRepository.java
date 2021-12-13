package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.TableEntity;

public interface TableRepository extends JpaRepository<TableEntity, Integer> {

}
