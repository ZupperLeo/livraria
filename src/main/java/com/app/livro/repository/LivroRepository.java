package com.app.livro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.livro.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

}
