package com.app.livro.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.app.livro.controller.dto.request.ExemplarRequest;
import com.app.livro.model.Exemplar;
import com.app.livro.model.Livro;
import com.app.livro.repository.ExemplarRepository;
import com.app.livro.repository.LivroRepository;

@RestController
@RequestMapping("livros/{isbn}/exemplares")
public class CadastraExemplarController {

	private final ExemplarRepository exemplarRepository;
	private final LivroRepository livroRepository;
	
	public CadastraExemplarController(ExemplarRepository exemplarRepository, LivroRepository livroRepository) {
		this.exemplarRepository = exemplarRepository;
		this.livroRepository = livroRepository;
	}
	
	@PostMapping
	public ResponseEntity<Void> cadastrar(@PathVariable String isbn, @Valid @RequestBody ExemplarRequest request) {
		Livro livro = livroRepository.findByIsbn(isbn).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Livro isbn %s não encontrado", isbn)));
		Exemplar exemplar = request.toModel(livro);
		
		exemplarRepository.save(exemplar);
		
		URI uri = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("livros/{isbn}/exemplares/{id}")
					.buildAndExpand(livro.getIsbn(), exemplar.getId())
					.toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
}
