package com.example.demo.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Jogo;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {

	
}
