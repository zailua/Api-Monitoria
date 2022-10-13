package com.example.demo.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "server")
public class Servidor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	
	@ManyToMany
	@JoinTable(name = "servers_rooms",
	joinColumns = {@JoinColumn(name="server_fk")},
	inverseJoinColumns = {@JoinColumn(name = "sala_fk")})
	private List<Sala> salas;
	
	
	
	
}
