package com.app.livro.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.app.livro.controller.dto.request.AutorRequest;
import com.app.livro.model.Autor;
import com.app.livro.repository.AutorRepository;

@RestController
@RequestMapping("/autores")
public class AutorController {

	private AutorRepository repository;
	
	public AutorController(AutorRepository repository) {
		this.repository = repository;
	}
	
    @PostMapping
    public ResponseEntity<Void> cadatrar(@RequestBody @Valid AutorRequest request, UriComponentsBuilder uriComponentsBuilder) {

        Autor novoAutor = request.toModel();

        repository.save(novoAutor);

        URI location = uriComponentsBuilder.path("/autores/{id}")
                .buildAndExpand(novoAutor.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
	
}
