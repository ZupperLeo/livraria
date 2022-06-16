package com.app.livro.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(nullable = false, unique = true)
	@Length(min = 1, max = 200)
	private String titulo;

	@NotBlank
	@Column(nullable = false)
	@Length(min = 1, max = 4000)
	private String descricacao;
	
	@NotNull
	@Column(nullable = false)
	@Past
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataPublicacao;
	
	@NotBlank
	@Length(min = 10, max = 13)
	private String isbn;

	@Deprecated
	public Livro() {}
	
	public Livro(@NotBlank @Length(min = 1, max = 200) String titulo,
			@NotBlank @Length(min = 1, max = 4000) String descricacao, @NotNull LocalDate dataPublicacao,
			@NotBlank @Length(min = 10, max = 13) String isbn) {
		this.titulo = titulo;
		this.descricacao = descricacao;
		this.dataPublicacao = dataPublicacao;
		this.isbn = isbn;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricacao() {
		return descricacao;
	}

	public void setDescricacao(String descricacao) {
		this.descricacao = descricacao;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	
	
}
