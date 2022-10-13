package com.example.demo.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Servidor;

@Repository
public interface ServidorRepository extends JpaRepository<Servidor, Long>{

}
