package com.app.livro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.livro.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long>{

}
