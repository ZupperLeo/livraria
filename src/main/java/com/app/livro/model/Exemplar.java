package com.app.livro.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Exemplar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private LocalDate dataCadastro;
	
	@ManyToOne
	private Livro isbn;
	
	@Deprecated
	public Exemplar() {}

	public Exemplar(LocalDate dataCadastro, Livro isbn) {
		this.dataCadastro = dataCadastro;
		this.isbn = isbn;
	}
	
	public Long getId() {
		return id;
	}
}
