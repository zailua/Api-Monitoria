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
import com.example.demo.entities.Servidor;
import com.example.demo.repositorys.JogoRepository;
import com.example.demo.repositorys.SalaRepository;
import com.example.demo.repositorys.ServidorRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/servidorcontroller")
public class ServidoresController {


	@Autowired
	private SalaRepository salaRepository;
	
	@Autowired
	private ServidorRepository servidorRepository;
	
	@Autowired
	private JogoRepository jogoRepository;
	
	
	//GET all
	@GetMapping("/servidores")
	public List<Sala> getAllServidores(){
		return salaRepository.findAll();
	}
	
	
	//GET by Id
	@GetMapping("/servidores/{id}")
	public ResponseEntity<Sala> getJogoById(@PathVariable Long id){
		Sala sala = salaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Sala inexistente com id "));
				return ResponseEntity.ok(sala);
	}
	
	//CREATE
	@PostMapping("/servidores")
	public Sala createJogo(@RequestBody Sala sala) {
		return salaRepository.save(sala);
	}
	
	
	//UPDATE
	@PutMapping("/servidores/{id}")
	public ResponseEntity<Sala> updateJogo(@PathVariable Long id, @RequestBody Sala servidoresDetails){
		
		Sala sala = salaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Sala inexistente com id "));
		Servidor servidor = servidorRepository.findById(servidoresDetails.getServidores().getId()).get();
		Jogo jogo = servidorRepository.findById(servidoresDetails.getJogo().getId()).get();
		
		sala.setNome(sala.getNome());
		sala.setGameGen(sala.getGameGen());
		sala.setJogo(jogo);
		
		Sala newJogo = salaRepository.save(sala);
		
		return ResponseEntity.ok(newJogo);
	}
	
	
	//DELETE
	@DeleteMapping("/servidores/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteJogo (@PathVariable Long id) {
		Sala sala = salaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("sala inexistente com id "));
		
		salaRepository.delete(sala);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
		
	}
	
	
	
	
}
