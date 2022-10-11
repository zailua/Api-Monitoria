package com.example.demo.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Sala;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Long>{

}
