package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Offices;

@Repository
public interface OfficesRepository extends JpaRepository<Offices, Integer> {

}
