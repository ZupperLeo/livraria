package com.app.livro.controller.dto.request;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.app.livro.model.Livro;
import com.fasterxml.jackson.annotation.JsonFormat;

public class LivroRequest {
	
	@NotBlank
	@Size(min = 1, max = 200)
	private String titulo;

	@NotBlank
	@Size(min = 1, max = 4000)
	private String descricao;
	
	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataPublicacao;
	
	@NotBlank
	private String isbn;

	public LivroRequest() {}
	
	public LivroRequest(@NotBlank @Size(min = 1, max = 200) String titulo,
			@NotBlank @Size(min = 1, max = 4000) String descricao, @NotNull LocalDate dataPublicacao,
			@NotBlank String isbn) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.dataPublicacao = dataPublicacao;
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
	
	public Livro toModel() {
		return new Livro(titulo, descricao, dataPublicacao, isbn);
	}
}
