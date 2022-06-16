package com.app.livro.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.app.livro.controller.dto.request.LivroRequest;
import com.app.livro.model.Livro;
import com.app.livro.repository.LivroRepository;

@RestController
@RequestMapping("/livros")
public class LivroController {

	@Autowired
	private LivroRepository repository;
	
	@PostMapping
	public ResponseEntity<Livro> cadastrar(@Valid @RequestBody LivroRequest request) {
		Livro livro = request.toModel();
		
		repository.save(livro);
		
		URI uri = ServletUriComponentsBuilder
						.fromCurrentRequest()
						.path("/{îd}")
						.buildAndExpand(livro.getId())
						.toUri();
		
		return ResponseEntity.created(uri).body(livro);
	}
	
}
