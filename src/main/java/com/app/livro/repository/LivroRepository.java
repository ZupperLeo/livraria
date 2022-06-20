package com.app.livro.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.livro.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

	Optional<Livro> findByIsbn(String isbn);
	
}
