package com.app.livro.controller.dto.request;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import com.app.livro.model.Exemplar;
import com.app.livro.model.Livro;

public class ExemplarRequest {

	private LocalDate dataCadastro = LocalDate.now();
	
	@NotBlank
	private String isbn;

	public ExemplarRequest() {}
	
	public LocalDate getDataCadastro() {
		return dataCadastro;
	}	
	
	public String getIsbn() {
		return isbn;
	}
	
	public Exemplar toModel(Livro livro) {
		return new Exemplar(dataCadastro, livro);
	}
	
}
