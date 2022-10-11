package com.example.demo.entities;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "game_room")
public class Sala {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name_room")
	private String nome;
	
	@Column(name = "game_gen")
	private String gameGen;
	
	@OneToMany(mappedBy = "jogo")
	private List<Jogo> jogos = new ArrayList<Jogo>();
	
	
	
	
	
	
	
	
	
	public Sala() {
		super();
		
	}




	public Sala(String nome, String gameGen) {
		super();
		this.nome = nome;
		this.gameGen = gameGen;
	}
	
	
	

	public Long getId() {
		return id;
	}






	public void setId(Long id) {
		this.id = id;
	}






	public String getNome() {
		return nome;
	}





	public void setNome(String nome) {
		this.nome = nome;
	}





	public String getGameGen() {
		return gameGen;
	}





	public void setGameGen(String gameGen) {
		this.gameGen = gameGen;
	}
	
	
	

}
