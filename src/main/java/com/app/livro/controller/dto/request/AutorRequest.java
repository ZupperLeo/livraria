package com.app.livro.controller.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import com.app.livro.model.Autor;

public class AutorRequest {

	@NotBlank
	@Length(min = 1, max = 120)
	private String nome;
	
	@Email
	@NotBlank
	@Length(min = 10, max = 120)
	private String email;
	
	@NotBlank
	@Length(min = 50, max = 2500)
	private String descricao;
	
	@CPF
	@NotBlank
	private String CPF;

	public AutorRequest(@NotBlank @Length(min = 1, max = 120) String nome,
			@NotBlank @Length(min = 10, max = 120) String email,
			@NotBlank @Length(min = 50, max = 2500) String descricao,
			@CPF @NotBlank String CPF) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
		this.CPF = CPF;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getCPF() {
		return CPF;
	}
	
	public Autor toModel() {
		return new Autor(nome, email, descricao, CPF);
	}
}
