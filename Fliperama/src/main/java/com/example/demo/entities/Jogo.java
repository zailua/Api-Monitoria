package com.example.demo.entities;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;




@Entity
@Table(name = "game")
public class Jogo {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@Column(name = "game_name")
	private String nome;
	
	@Column(name= "game_value")
	private float valor;
	
	
	@ManyToOne
	@JoinColumn(name = "Game_id")
	private Sala sala;
	
	
	
	




	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	
	public Jogo() {
		
		
	}
	
	public Jogo(String nome, float valor) {
		super();
		this.nome = nome;
		this.valor = valor;
	}
	


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public float getValor() {
		return valor;
	}


	public void setValor(float valor) {
		this.valor = valor;
	}
	
	
	
	
	

}
