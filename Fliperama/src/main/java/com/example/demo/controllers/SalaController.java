package com.example.demo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ResourceNotFoundException;
import com.example.demo.entities.Jogo;
import com.example.demo.entities.Sala;
import com.example.demo.repositorys.JogoRepository;
import com.example.demo.repositorys.SalaRepository;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/salacontroller")
public class SalaController {
	
	@Autowired
	private SalaRepository salaRepository;
	
	@Autowired 
	private JogoRepository jogoRepository;
	
	
	//GET all
	@GetMapping("/salas")
	public List<Sala> getAllJogos(){
		return salaRepository.findAll();
	}
	
	
	//GET by Id
	@GetMapping("/salas/{id}")
	public ResponseEntity<Sala> getJogoById(@PathVariable Long id){
		Sala sala = salaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Sala inexistente com id "));
				return ResponseEntity.ok(sala);
	}
	
	//CREATE
	@PostMapping("/salas")
	public Sala createJogo(@RequestBody Sala sala) {
		return salaRepository.save(sala);
	}
	
	
	//UPDATE
	@PutMapping("/salas/{id}")
	public ResponseEntity<Sala> updateJogo(@PathVariable Long id, @RequestBody Sala jogosDetails){
		
		Sala sala = salaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Sala inexistente com id "));
		Jogo jogo = jogoRepository.findById(jogosDetails.getJogo().getId()).get();
		
		sala.setNome(sala.getNome());
		sala.setGameGen(sala.getGameGen());
		sala.setJogo(jogo);
		
		Sala newJogo = salaRepository.save(sala);
		
		return ResponseEntity.ok(newJogo);
	}
	
	
	//DELETE
	@DeleteMapping("/salas/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteJogo (@PathVariable Long id) {
		Sala sala = salaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("sala inexistente com id "));
		
		salaRepository.delete(sala);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
		
	}
}
