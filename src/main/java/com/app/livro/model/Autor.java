package com.app.livro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

@Entity
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(nullable = false, length = 120)
	private String nome;
	
	@Email
	@NotBlank
	@Column(nullable = false, length = 120)	
	private String email;
	
	@NotBlank
	@Column(nullable = false, length = 2500)
	private String descricao;
	
	@CPF
	@NotBlank
	@Column(nullable = false)
	private String CPF;
	
	@Deprecated
	public Autor() {}

	public Autor(@NotBlank String nome, @NotBlank String email, @NotBlank String descricao,
			@org.hibernate.validator.constraints.br.CPF @NotBlank String CPF) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
		this.CPF = CPF;
	}
	
	public Long getId() {
		return id;
	}
	
}
