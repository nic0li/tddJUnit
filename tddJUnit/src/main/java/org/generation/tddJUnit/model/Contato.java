package org.generation.tddJUnit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Contato {
	
	// ATRIBUTOS
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	@NotEmpty(message = "O DDD deve ser preenchido.") 
	private String ddd;
	
	@NotEmpty(message = "O telefone deve ser preenchido.") 
	private String telefone;
	
	@NotEmpty(message = "O nome deve ser preenchido.") 
	private String nome;
	
	// CONSTRUTORES

	public Contato() {

	}

	public Contato(String ddd, String telefone, String nome) {
		super();
		this.ddd = ddd;
		this.telefone = telefone;
		this.nome = nome;
	}
	
	// ENCAPSULAMENTO

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	

}
